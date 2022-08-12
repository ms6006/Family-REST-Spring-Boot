package com.example.FamilyMemberApp.service;

import com.example.FamilyMemberApp.model.FamilyMember;
import com.example.FamilyMemberApp.repo.FamilyMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FamilyMemberService {

    @Autowired
    private FamilyMemberRepository familyMemberRepository;
    //Metoda dodawania członków rodziny do bazy danych
    public void createFamilyMember(FamilyMember familyMemberDB, int familyId){
        //Podajemy indeks rodziny członkowi rodziny
        familyMemberDB.setFamilyId(familyId);
        //Dodajemy do bazy
        familyMemberRepository.save(familyMemberDB);
    }
    //Metoda wyszukiwania członków rodziny według indeksu rodziny
    public List<FamilyMember> searchFamilyMember(int familyId){
        return familyMemberRepository.findByFamilyId(familyId);
    }
}
