package com.example.family_app.service;

import com.example.family_app.models.Family;
import com.example.family_app.models.FamilyMember;
import com.example.family_app.repo.FamilyRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class FamilyService {

    @Value("${server.to.connect}")
    String server;

    @Autowired
    private FamilyRepository familyRepository;

    //Metoda weryfikacji danych
    public boolean validateFamilyData(FamilyMember[] familyMemberDB, int nrOfAdults, int nrOfChildren, int nrOfInfants){
        for (FamilyMember memberDB : familyMemberDB) {
            if (0 <= memberDB.getAge() && memberDB.getAge() < 4) nrOfInfants--;
            if (4 <= memberDB.getAge() && memberDB.getAge() < 16) nrOfChildren--;
            if (16 <= memberDB.getAge()) nrOfAdults--;
        }
        return ((nrOfAdults == 0) && (nrOfChildren == 0) && (nrOfInfants == 0));
    }

    //Metoda tworzenia i zapisywania rodziny do bazy danych
    public int createFamily(String familyName, int nrOfAdults, int nrOfChildren, int nrOfInfants, FamilyMember[] familyMemberDB){
        //Tworzymy nowy obiekt rodziny
        Family family = new Family(familyName, nrOfAdults, nrOfChildren, nrOfInfants);
        if(validateFamilyData(familyMemberDB, nrOfAdults, nrOfChildren, nrOfInfants)) {
            //Jeśli dane zostały zweryfikowane
            //Rejestrujemy rodzinę w bazie danych
            familyRepository.save(family);
            //Wszystkie dane dotyczące członków rodziny przekazujemy do FamilyMemberApp
            for (FamilyMember memberDB : familyMemberDB)
                Unirest.post("http://"+server+":9090/createFamilyMember?familyId={familyId}").header("Content-Type", "application/json").body(memberDB).routeParam("familyId", String.valueOf(family.getId())).asEmpty();
        }
        return family.getId();
    }

    //Metoda pobierania danych rodzinnych z bazy danych w formacie Map, gdzie rodzina jest kluczem, a dane członków rodziny - value
    public Map<Family, List<FamilyMember>> getFamily(int id){
        return familyRepository.findById(id).stream().collect(Collectors.toMap(Function.identity(), this::getFamilyMembers));
    }

    //Metoda pobierania danych członków rodziny
    private List<FamilyMember> getFamilyMembers(Family familyDB) {
        //Żądamy danych od FamilyMemberApp
        HttpResponse<String> response = Unirest.get("http://"+server+":9090/search?familyId={familyId}").routeParam("familyId", String.valueOf(familyDB.getId())).asString();
        try {
            //Zwracamy dane jako listę członków rodziny
            return Arrays.asList(new ObjectMapper().readValue(response.getBody(), FamilyMember[].class));

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
