package com.mutantsapi.mutants.controllers;

import com.mutantsapi.mutants.models.Person;
import com.mutantsapi.mutants.repositories.PersonRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository){
        this.personRepository = personRepository;
    }


    @PostMapping("/mutant/")
    Person newPerson(@RequestBody Person person){
        return personRepository.save(person);
    }

}
