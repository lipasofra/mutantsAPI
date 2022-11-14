package com.mutantsapi.mutants.services;

import com.mutantsapi.mutants.models.DNA;
import com.mutantsapi.mutants.repositories.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;



    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);


    }

    @Test
    void verifyExistence() {

        String[] dna = {"ATACGA", "CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};

        when(personRepository.existsByDna(dna)).thenReturn(true);
        assertTrue(personService.verifyExistence(dna));

    }

    @Test
    void mutantsQuantity() {

        when(personRepository.countByIsMutant(true)).thenReturn(any(Long.class));
        assertNotNull(personService.mutantsQuantity(true));


    }

    @Test
    void mutantsRatio() {

        assertNotNull(String.valueOf(personService.mutantsRatio(8L, 4L)),2.0);

    }
}