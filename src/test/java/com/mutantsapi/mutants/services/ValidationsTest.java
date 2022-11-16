package com.mutantsapi.mutants.services;

import com.mutantsapi.mutants.exceptions.ValidationsException;
import com.mutantsapi.mutants.services.validations.ValidateDimension;
import com.mutantsapi.mutants.services.validations.ValidateDimensionImplement;
import com.mutantsapi.mutants.services.validations.ValidateLetters;
import com.mutantsapi.mutants.services.validations.ValidateLettersImplement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


public class ValidationsTest {


    @Test
    void dnaAlreadyExistsIntegration() throws Exception {

        String[] dna = {"ATACGA", "CAGTGC","TTATGT","AGAAGG","TCACTG"};

        ValidateDimension validateDimension = Mockito.mock(ValidateDimension.class);
        when(validateDimension.validateDimension(any())).thenReturn(true);

        ValidateLetters validateLetters = Mockito.mock(ValidateLetters.class);
        when(validateLetters.validateLetters(any())).thenReturn(true);

        PersonService personService = Mockito.mock(PersonService.class);
        when(personService.verifyExistence(any())).thenReturn(true);


        MutationValidationImp mutationValidationImp= new MutationValidationImp(validateDimension, validateLetters,
                personService);

        Exception ex = Assertions.assertThrows(ValidationsException.class,
                () -> mutationValidationImp.validations(dna) );

        String expectedMessage = "Already exists a person with that DNA, try with other one";
        String actualMessage = ex.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));

    }


    @Test
    void wrongDimensionDnaIntegration() {

        String[] dna = {"ATACGA", "CAGTGC","TTATGT","AGAAGG","TCACTG"};

        ValidateDimension validateDimension = Mockito.mock(ValidateDimension.class);
        when(validateDimension.validateDimension(any())).thenReturn(false);

        ValidateLetters validateLetters = Mockito.mock(ValidateLetters.class);
        when(validateLetters.validateLetters(any())).thenReturn(true);

        PersonService personService = Mockito.mock(PersonService.class);
        when(personService.verifyExistence(any())).thenReturn(false);


        MutationValidationImp mutationValidationImp= new MutationValidationImp(validateDimension, validateLetters,
                personService);

        Exception ex = Assertions.assertThrows(ValidationsException.class,
                () -> mutationValidationImp.validations(dna) );

        String expectedMessage = "The dimensions of the DNA are not square";
        String actualMessage = ex.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void shorterDna() {

        String[] dna = {"AT", "CA"};

        ValidateDimension validateDimension = Mockito.mock(ValidateDimension.class);
        when(validateDimension.validateDimension(any())).thenReturn(true);

        ValidateLetters validateLetters = Mockito.mock(ValidateLetters.class);
        when(validateLetters.validateLetters(any())).thenReturn(true);

        PersonService personService = Mockito.mock(PersonService.class);
        when(personService.verifyExistence(any())).thenReturn(false);


        MutationValidationImp mutationValidationImp= new MutationValidationImp(validateDimension, validateLetters,
                personService);

        Exception ex = Assertions.assertThrows(ValidationsException.class,
                () -> mutationValidationImp.validations(dna) );

        String expectedMessage = "DNA must be larger than 3 codes";
        String actualMessage = ex.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void otherLetterDnaIntegration() {

        String[] dna = {"ATACGA", "CAGTGC","TTATHT","AGAAGG","CCCCTA","TCACTG"};

        ValidateDimension validateDimension = Mockito.mock(ValidateDimension.class);
        when(validateDimension.validateDimension(any())).thenReturn(true);

        ValidateLetters validateLetters = Mockito.mock(ValidateLetters.class);
        when(validateLetters.validateLetters(any())).thenReturn(false);

        PersonService personService = Mockito.mock(PersonService.class);
        when(personService.verifyExistence(any())).thenReturn(false);


        MutationValidationImp mutationValidationImp= new MutationValidationImp(validateDimension, validateLetters,
                personService);

        Exception ex = Assertions.assertThrows(ValidationsException.class,
                () -> mutationValidationImp.validations(dna) );

        String expectedMessage = "The DNA has not allowed nitrogenous bases. The only allowed are A, " +
                "T, G, C";
        String actualMessage = ex.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void otherLetterDnaUnit() {

        String[] dna = {"ATACGA", "CAGTGC","TTATHT","AGAAGG","CCCCTA","TCACTG"};
        ValidateLettersImplement validateLetters = new ValidateLettersImplement();

        assertFalse(validateLetters.validateLetters(dna));
    }


    @Test
    void wrongDimensionDnaUnit() {

        String[] dna = {"ATACGA", "CAGTGC","AGAAGG","CCCCTA","TCACTG"};
        ValidateDimensionImplement validateDimension = new ValidateDimensionImplement();

        assertFalse(validateDimension.validateDimension(dna));
    }

    @Test
    void goodDimensionDnaUnit() {

        String[] dna = {"ATACGA", "CAGTGC","TTATHT","AGAAGG","CCCCTA","TCACTG"};
        ValidateDimensionImplement validateDimension = new ValidateDimensionImplement();

        assertTrue(validateDimension.validateDimension(dna));
    }


    @Test
    void null_input() throws Exception {

        String[] dna = null;

        ValidateDimension validateDimension = Mockito.mock(ValidateDimension.class);
        when(validateDimension.validateDimension(any())).thenReturn(true);

        ValidateLetters validateLetters = Mockito.mock(ValidateLetters.class);
        when(validateLetters.validateLetters(any())).thenReturn(true);

        PersonService personService = Mockito.mock(PersonService.class);
        when(personService.verifyExistence(any())).thenReturn(false);


        MutationValidationImp mutationValidationImp= new MutationValidationImp(validateDimension, validateLetters,
                personService);

        Exception ex = Assertions.assertThrows(ValidationsException.class,
                () -> mutationValidationImp.validations(dna) );

        String expectedMessage = "Is mandatory to provide a DNA array";
        String actualMessage = ex.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

}
