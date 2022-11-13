package com.mutantsapi.mutants.models.dtos;

import java.util.Arrays;
import java.util.List;

public class ValidateLettersImplement implements ValidateLetters {

    @Override
    public boolean validateLetters(String[] dna) {

            List<String> letters= Arrays.asList("T", "G", "A", "C");

            boolean pass = true;

            outterloop: for (int row = 0; row < dna.length; row++) {
                for(int column = 0; column < dna.length; column++) {
                    char letter = dna[row].charAt(column);
                    if (letters.contains(Character.toString(letter))) {
                        continue;
                    } else {
                        System.out.println("Hay una letra diferente a las permitidas");
                        pass = false;
                        break outterloop;
                    }
                }
            }
            return pass;

    }
}
