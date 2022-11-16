package com.mutantsapi.mutants.services.validations;

import org.springframework.stereotype.Service;


public interface ValidateLetters {

    boolean validateLetters(String[] dna);
}
