package com.mutantsapi.mutants.services;

import com.mutantsapi.mutants.models.DNA;
import com.mutantsapi.mutants.services.searches.SearchesImpl;
import com.mutantsapi.mutants.services.validations.ValidateDimension;
import com.mutantsapi.mutants.services.validations.ValidateLetters;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

class IsMutantTest {


    @Test
    void personIsMutant() {

        String[] dnaArray = {"ATACGA", "CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        DNA dna = new DNA(dnaArray);

        ValidateDimension validateDimension = Mockito.mock(ValidateDimension.class);
        when(validateDimension.validateDimension(any())).thenReturn(true);

        ValidateLetters validateLetters = Mockito.mock(ValidateLetters.class);
        when(validateLetters.validateLetters(any())).thenReturn(true);

        PersonService personService = Mockito.mock(PersonService.class);
        when(personService.verifyExistence(any())).thenReturn(false);

        SearchesImpl searches = Mockito.mock(SearchesImpl.class);
        when(searches.searchDiagonalNegative(any(), anyInt())).thenReturn(1);
        when(searches.searchDiagonalPositive(any(), anyInt())).thenReturn(0);
        when(searches.searchHorizontal(any(), anyInt())).thenReturn(1);
        when(searches.searchVertical(any(), anyInt())).thenReturn(1);

        MutationValidationImp mutationValidationImp= new MutationValidationImp(validateDimension, validateLetters,
                searches, personService);

        assertTrue(mutationValidationImp.isMutant(dna));

    }

    @Test
    void personIsHuman() {

        String[] dnaArray = {"ATACGA", "CAGTGC","TTATGT","AAAAGG","CCCCTA","TCACTG"};
        DNA dna = new DNA(dnaArray);

        ValidateDimension validateDimension = Mockito.mock(ValidateDimension.class);
        when(validateDimension.validateDimension(any())).thenReturn(true);

        ValidateLetters validateLetters = Mockito.mock(ValidateLetters.class);
        when(validateLetters.validateLetters(any())).thenReturn(true);

        PersonService personService = Mockito.mock(PersonService.class);
        when(personService.verifyExistence(any())).thenReturn(false);

        SearchesImpl searches = Mockito.mock(SearchesImpl.class);
        when(searches.searchDiagonalNegative(any(), anyInt())).thenReturn(1);
        when(searches.searchDiagonalPositive(any(), anyInt())).thenReturn(0);
        when(searches.searchHorizontal(any(), anyInt())).thenReturn(2);
        when(searches.searchVertical(any(), anyInt())).thenReturn(1);

        MutationValidationImp mutationValidationImp= new MutationValidationImp(validateDimension, validateLetters,
                searches, personService);

        assertFalse(mutationValidationImp.isMutant(dna));

    }


}