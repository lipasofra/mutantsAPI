package com.mutantsapi.mutants.controllers;

import com.mutantsapi.mutants.exceptions.ValidationsException;
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

        //boolean InputInstance = originalDna.dna instanceof String[]; CORREGIR!!
        /*if(!InputInstance ){
            throw new ValidationsException("You have not provided a DNA array");
        }*/


        /*validaciones para poder analizar si es mutante*/
        mutationValidation.validations(dna);

        /*Analisis de mutación y armado del perfil para guardar en la BD*/
        Boolean personMutant = mutationValidation.isMutant(originalDna);
        person.setIsMutant(personMutant);
        person.setDna(originalDna.dna);

        /*Guardar la persona en la BD y retornar Http Status solicitado*/
        personRepository.save(person);
        if(personMutant){
            return new ResponseEntity<>("Is mutant", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Is human", HttpStatus.FORBIDDEN);
        }



    }

}
