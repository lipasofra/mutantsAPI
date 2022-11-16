package com.mutantsapi.mutants.services.validations;

import org.springframework.stereotype.Service;


public interface ValidateDimension {

    Boolean validateDimension(String[] dna);
}
