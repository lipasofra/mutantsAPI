package com.mutantsapi.mutants.services;

import com.mutantsapi.mutants.models.DNA;
import org.springframework.stereotype.Service;

public interface MutationValidation {

    /**
     * Verify if is mutant by finding sequences of 4 equal characters
     *  (less than 2 for each direction of a matrix).
     * @param dna User input of Json with DNa string array code
     * @return true if is mutant, false if is not (is human)
     */
    boolean isMutant(DNA dna);

    void validations(String[] dna);
}
