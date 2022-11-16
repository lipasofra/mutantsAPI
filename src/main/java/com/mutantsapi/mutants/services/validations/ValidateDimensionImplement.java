package com.mutantsapi.mutants.services.validations;

import org.springframework.stereotype.Service;

@Service
public class ValidateDimensionImplement implements ValidateDimension {

    @Override
    public Boolean validateDimension(String[] dna) {
        boolean pass = true;

        for (int i = 0; i < dna.length; i++) {
            if (dna[i].length() == dna.length){
                continue;
            } else {
                System.out.println("Dimensiones no cuadran");
                pass = false;
                break;
            }
        }
        return pass;
    }

}
