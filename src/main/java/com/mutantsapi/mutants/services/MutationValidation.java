package com.mutantsapi.mutants.services;

import com.mutantsapi.mutants.models.dtos.ValidateDimension;
import com.mutantsapi.mutants.models.dtos.ValidateLetters;
import com.mutantsapi.mutants.repositories.PersonRepository;
import com.mutantsapi.mutants.services.searches.Searches;

import java.util.Arrays;
import java.util.List;

public class MutationValidation {

    private ValidateDimension validateDimension;
    private ValidateLetters validateLetters;
    private Searches searches;
    private PersonRepository personRepository;

    public MutationValidation(PersonRepository personRepository, ValidateDimension validateDimension,
                              ValidateLetters validateLetters, Searches searches) {
        this.personRepository = personRepository;
        this.validateDimension = validateDimension;
        this.validateLetters = validateLetters;
        this.searches = searches;
    }

    public boolean isMutant(String[] dna){

        boolean passDimensions = true;
        boolean passLetters = true;

        passDimensions = validateDimension.validateDimension(dna);
        passLetters = validateLetters.validateLetters(dna);


        char[][] matrix = fillMatrix(dna);
        int diagonalNegative = searches.searchDiagonalNegative(matrix, dna.length);
        int diagonalPositive = searches.searchDiagonalPositive(matrix, dna.length);
        int horizontal = searches.searchHorizontal(matrix, dna.length);
        int vertical = searches.searchVertical(matrix, dna.length);

        System.out.println(diagonalNegative);
        System.out.println(diagonalPositive);
        System.out.println(horizontal);
        System.out.println(vertical);

        if(diagonalNegative > 1 || diagonalPositive > 1 || horizontal > 1 || vertical > 1){
            return false;
        } else if (diagonalNegative + diagonalPositive + horizontal + vertical <= 1){
            return false;
        } else {
            return true;
        }
    }



    static char[][] fillMatrix(String[] dna){


        int len = dna.length;
        char[][] matrix = new char[len][len];
        outterloop: for (int row = 0; row < dna.length; row++) {
            for(int column = 0; column < dna.length; column++){
                char letter = dna[row].charAt(column);
                matrix[row][column] = dna[row].charAt(column);
                System.out.print(matrix[row][column]);
            }
            System.out.println();
        }
        return matrix;
    }
}
