package com.mutantsapi.mutants.controllers;

import com.mutantsapi.mutants.exceptions.NotAllowedLettersException;
import com.mutantsapi.mutants.exceptions.NotEqualDimensionsException;
import com.mutantsapi.mutants.models.DNA;
import com.mutantsapi.mutants.models.Person;
import com.mutantsapi.mutants.models.dtos.ValidateDimension;
import com.mutantsapi.mutants.models.dtos.ValidateLetters;
import com.mutantsapi.mutants.repositories.PersonRepository;
import com.mutantsapi.mutants.services.MutationValidation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    private final PersonRepository personRepository;
    private final MutationValidation mutationValidation;
    private final ValidateLetters validateLetters;
    private final ValidateDimension validateDimension;

    public PersonController(PersonRepository personRepository, MutationValidation mutationValidation, ValidateLetters validateLetters, ValidateDimension validateDimension){
        this.personRepository = personRepository;
        this.mutationValidation = mutationValidation;
        this.validateLetters = validateLetters;
        this.validateDimension = validateDimension;
    }


    @PostMapping("/mutant/")
    HttpStatus newPerson(@RequestBody DNA originalDna){

        //Person person = null; cambiarlo, no puede ser null

        String[] dna = originalDna.dna;

        /*validaciones para analizar si es mutante*/
        if(!validateDimension.validateDimension(dna)){
            throw new NotEqualDimensionsException("The dimensions of the DNA are not square");
        }
        if(!validateLetters.validateLetters(dna)){
            throw new NotAllowedLettersException("The DNA has not allowed nitrogenous bases. The only allowed are A, " +
                    "T, G, C");
        }

        /*Analisis de mutación y armado del perfil para guardar en la BD*/
        //person.setIsMutant(mutationValidation.isMutant(originalDna));
        //person.setDna(originalDna);


        if(mutationValidation.isMutant(originalDna)){
            return HttpStatus.OK;
        } else {
            return HttpStatus.FORBIDDEN;
        }


        /*Guardar la persona en la BD*/
        //return personRepository.save(person);

    }

}
