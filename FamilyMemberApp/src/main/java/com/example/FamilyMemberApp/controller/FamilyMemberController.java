package com.example.FamilyMemberApp.controller;

import com.example.FamilyMemberApp.model.FamilyMember;
import com.example.FamilyMemberApp.service.FamilyMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FamilyMemberController {

    @Autowired
    private FamilyMemberService familyMemberService;

    @PostMapping("/createFamilyMember")
    public void createFamilyMember(@RequestBody FamilyMember familyMemberDB, @RequestParam("familyId") int familyId){
        //Wywołujemy metodę zapisu członka rodziny do bazy danych z familyMemberService
        familyMemberService.createFamilyMember(familyMemberDB, familyId);
    }

    @GetMapping("/search")
    public List<FamilyMember> searchFamilyMember(@RequestParam("familyId") int familyId){
        //Wywołujemy metodę wyszukiwania członka rodziny w bazie danych z familyMemberService
        return familyMemberService.searchFamilyMember(familyId);
    }
}
