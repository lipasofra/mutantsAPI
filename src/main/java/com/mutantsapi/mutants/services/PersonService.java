package com.mutantsapi.mutants.services;

import com.mutantsapi.mutants.models.Person;
import com.mutantsapi.mutants.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PersonService {

        @Autowired
        private PersonRepository personRepository;

    public boolean verifyExistence(String[] dna){
        return personRepository.existsByDna(dna);
    }
}
