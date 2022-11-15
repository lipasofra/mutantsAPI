package com.mutantsapi.mutants.services;

import com.mutantsapi.mutants.exceptions.InputTypeExceptionHandler;
import com.mutantsapi.mutants.exceptions.ValidationsAdvice;
import com.mutantsapi.mutants.exceptions.ValidationsException;
import com.mutantsapi.mutants.models.DNA;
import com.mutantsapi.mutants.services.searches.Searches;
import com.mutantsapi.mutants.services.validations.ValidateDimension;
import com.mutantsapi.mutants.services.validations.ValidateDimensionImplement;
import com.mutantsapi.mutants.services.validations.ValidateLetters;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class IsMutantTest {

    @Mock
    private DNA dna;
    @Mock
    private ValidateDimension validateDimension;
    @Mock
    private ValidateLetters validateLetters;
    @Mock
    private Searches searches;
    @Mock
    private PersonService personService;

    @InjectMocks
    private MutationValidationImp mutationValidation;

    @InjectMocks
    private MutationValidation mutationValidationn;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void person_is_Mutant() {
        String[] dnaArray = {"ATACGA", "CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        DNA dnaObject = new DNA(dnaArray);

        when(searches.searchVertical(mutationValidation.fillMatrix(dnaObject.getDna()), dnaArray.length)).thenReturn(1);
        when(searches.searchHorizontal(mutationValidation.fillMatrix(dnaObject.getDna()), dnaArray.length)).thenReturn(1);
        when(searches.searchDiagonalNegative(mutationValidation.fillMatrix(dnaObject.getDna()), dnaArray.length)).thenReturn(1);
        when(searches.searchDiagonalPositive(mutationValidation.fillMatrix(dnaObject.getDna()), dnaArray.length)).thenReturn(0);

        assertTrue(mutationValidation.isMutant(dnaObject));

    }

    @Test
    void person_is_Human() {
    }


}