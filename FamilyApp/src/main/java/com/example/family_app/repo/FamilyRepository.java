package com.example.family_app.repo;

import com.example.family_app.models.Family;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilyRepository extends CrudRepository<Family, Integer> {
}
