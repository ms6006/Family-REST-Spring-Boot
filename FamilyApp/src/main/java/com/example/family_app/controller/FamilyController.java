package com.example.family_app.controller;

import com.example.family_app.models.Family;
import com.example.family_app.models.FamilyMember;
import com.example.family_app.service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class FamilyController {

    @Autowired
    private FamilyService familyService;


    @PostMapping("/createFamily")
    public int createFamily(@RequestParam("familyName") String familyName, @RequestParam("nrOfAdults") int nrOfAdults, @RequestParam("nrOfChildren") int nrOfChildren,
                             @RequestParam("nrOfInfants") int nrOfInfants, @RequestBody FamilyMember[] familyMemberDB){
        //Wywołanie metody tworzenia rodziny z familyService
        return familyService.createFamily(familyName, nrOfAdults, nrOfChildren, nrOfInfants, familyMemberDB);

    }

    @GetMapping("/getFamily")
    public ResponseEntity<Map<Family, List<FamilyMember>>> getFamily(@RequestParam("id") int id){
        //Wywołanie metody wyszukiwania rodziny z familyService
        return new ResponseEntity<>(familyService.getFamily(id), HttpStatus.OK);

    }

}
