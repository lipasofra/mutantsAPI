package com.mutantsapi.mutants.services;

import com.mutantsapi.mutants.models.DNA;
import com.mutantsapi.mutants.services.validations.ValidateDimension;
import com.mutantsapi.mutants.services.validations.ValidateLetters;
import com.mutantsapi.mutants.services.searches.Searches;

public class MutationValidationImp implements MutationValidation{

    private ValidateDimension validateDimension;
    private ValidateLetters validateLetters;
    private Searches searches;

    public MutationValidationImp(ValidateDimension validateDimension,
                                 ValidateLetters validateLetters, Searches searches) {
        this.validateDimension = validateDimension;
        this.validateLetters = validateLetters;
        this.searches = searches;
    }

    @Override
    public boolean isMutant(DNA originalDna){


        String[] dna = originalDna.dna;


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
                char letter = dna[row].toUpperCase().charAt(column);
                matrix[row][column] = letter;
                System.out.print(matrix[row][column]);
            }
            System.out.println();
        }
        return matrix;
    }
}