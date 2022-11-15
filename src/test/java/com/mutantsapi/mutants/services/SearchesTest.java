package com.mutantsapi.mutants.services;

import com.mutantsapi.mutants.services.searches.Searches;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNotNull;

public class SearchesTest {

    @Test
    void several_diagonal_positive_matches() {

        //Searches searches = new Searches();
       // MutationValidation mutationValidation = new MutationValidationImp();

        String[] dna = {"ATACGA", "CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
       // char[][] matrix = mutationValidation.fillMatrix(dna);

      //  assertNotNull(searches.searchDiagonalPositive(matrix, dna.length));

    }

    @Test
    void none_diagonal_positive_matches() {
    }

    @Test
    void several_diagonal_negative_matches() {
    }

    @Test
    void none_diagonal_negative_matches() {
    }

    @Test
    void horizontal_matches() {
    }

    @Test
    void none_vertical_matches() {
    }



}
