package com.example.FamilyMemberApp.repo;

import com.example.FamilyMemberApp.model.FamilyMember;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FamilyMemberRepository extends CrudRepository<FamilyMember, Integer> {
    //Określiliśmy zapytanie(Query), aby wyszukać członka rodziny według indeksu rodziny w bazie danych
    @Query("select * from family_member where family_id = :familyid")
    List<FamilyMember> findByFamilyId(@Param("familyid") int familyId);

}
