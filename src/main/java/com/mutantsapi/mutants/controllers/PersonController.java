package com.mutantsapi.mutants.controllers;

import com.mutantsapi.mutants.exceptions.NotAllowedLettersException;
import com.mutantsapi.mutants.exceptions.NotEqualDimensionsException;
import com.mutantsapi.mutants.models.DNA;
import com.mutantsapi.mutants.models.Person;
import com.mutantsapi.mutants.services.PersonService;
import com.mutantsapi.mutants.services.validations.ValidateDimension;
import com.mutantsapi.mutants.services.validations.ValidateLetters;
import com.mutantsapi.mutants.repositories.PersonRepository;
import com.mutantsapi.mutants.services.MutationValidation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    private final PersonRepository personRepository;
    private final MutationValidation mutationValidation;
    private final ValidateLetters validateLetters;
    private final ValidateDimension validateDimension;
    private final PersonService personService;

    public PersonController(PersonRepository personRepository, MutationValidation mutationValidation, ValidateLetters validateLetters, ValidateDimension validateDimension, PersonService personService){
        this.personRepository = personRepository;
        this.mutationValidation = mutationValidation;
        this.validateLetters = validateLetters;
        this.validateDimension = validateDimension;
        this.personService = personService;
    }


    @PostMapping("/mutant/")
    public Object newPerson(@RequestBody DNA originalDna){

        Person person = new Person();
        String[] dna = originalDna.dna;

        boolean InputInstance = originalDna.dna instanceof String[];


        if(!InputInstance ){
            throw new NotEqualDimensionsException("You have not provided a DNA array");
        }

        /*validaciones para poder analizar si es mutante*/
        if(personService.verifyExistence(dna)){
            throw new NotEqualDimensionsException("Already exists a person with that DNA, try with other one");
        }
        if(originalDna.dna == null){
            throw new NotEqualDimensionsException("Is mandatory to provide a DNA array");
        }
        if(dna.length<4){
            throw new NotEqualDimensionsException("DNA must be larger than 3 codes");
        }
        if(!validateDimension.validateDimension(dna)){
            throw new NotEqualDimensionsException("The dimensions of the DNA are not square");
        }
        if(!validateLetters.validateLetters(dna)){
            throw new NotAllowedLettersException("The DNA has not allowed nitrogenous bases. The only allowed are A, " +
                    "T, G, C");
        }

        /*Analisis de mutación y armado del perfil para guardar en la BD*/
        Boolean personMutant = mutationValidation.isMutant(originalDna);
        person.setIsMutant(personMutant);
        person.setDna(originalDna.dna);

        /*Guardar la persona en la BD y retornar Http Status solicitado*/
        personRepository.save(person);
        if(personMutant){
            return new ResponseEntity<>("es mutante", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("es humano", HttpStatus.FORBIDDEN);
        }



    }

}
