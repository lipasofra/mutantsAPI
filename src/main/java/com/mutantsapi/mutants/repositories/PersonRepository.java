package com.mutantsapi.mutants.repositories;

import com.mutantsapi.mutants.models.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository <Person, String> {
    boolean existsByDna(String[] dna);
}
