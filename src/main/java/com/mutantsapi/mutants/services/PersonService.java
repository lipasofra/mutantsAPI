package com.mutantsapi.mutants.services;

import com.mutantsapi.mutants.models.Person;
import com.mutantsapi.mutants.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Cacheable("dnaExistence")
    public boolean verifyExistence(String[] dna){
        return personRepository.existsByDna(dna);
    }


    public long mutantsQuantity(boolean isMutant){
        return personRepository.countByIsMutant(isMutant);
    }

    public Person save(Person person){
        return personRepository.save(person);
    }


    public double mutantsRatio(long mutants, long humans){
        double ratio = (double)mutants/(double)humans;
        return ratio;
    }
}
