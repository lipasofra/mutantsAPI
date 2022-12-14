package com.mutantsapi.mutants.controllers;

import com.mutantsapi.mutants.exceptions.ValidationsException;
import com.mutantsapi.mutants.models.DNA;
import com.mutantsapi.mutants.models.Person;
import com.mutantsapi.mutants.models.Stats;
import com.mutantsapi.mutants.services.PersonService;
import com.mutantsapi.mutants.services.validations.ValidateDimension;
import com.mutantsapi.mutants.services.validations.ValidateLetters;
import com.mutantsapi.mutants.repositories.PersonRepository;
import com.mutantsapi.mutants.services.MutationValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class PersonController {


    @Autowired
    private MutationValidation mutationValidation;

    private PersonService personService;

    private Stats stats;
    private boolean consultStats = true;

    @Autowired
    public PersonController(MutationValidation mutationValidation, PersonService personService){
        this.mutationValidation = mutationValidation;
        this.personService = personService;
    }

    @GetMapping("/stats")
    public Stats statistics(){

        if (consultStats){
            long mutants = personService.mutantsQuantity(true);
            long humans = personService.mutantsQuantity(false);
            double ratio = personService.mutantsRatio(mutants, humans);
            stats = new Stats(mutants, humans, ratio);
            consultStats = false;
        }
        return stats;

    }


    @PostMapping("/mutant/")
    public Object newPerson(@RequestBody DNA originalDna){

        Person person = new Person();
        String[] dna = originalDna.dna;


        /*validaciones para poder analizar si es mutante*/
        mutationValidation.validations(dna);

        /*Analisis de mutaci??n y armado del perfil para guardar en la BD*/
        Boolean personMutant = mutationValidation.isMutant(originalDna);
        person.setIsMutant(personMutant);
        person.setDna(originalDna.dna);

        /*Guardar la persona en la BD y retornar Http Status solicitado*/
        personService.save(person);
        consultStats = true;
        if(personMutant){
            return new ResponseEntity<>("Is mutant", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Is human", HttpStatus.FORBIDDEN);
        }
    }

}
