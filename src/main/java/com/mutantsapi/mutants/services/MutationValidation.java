package com.mutantsapi.mutants.services;

import com.mutantsapi.mutants.models.DNA;

public interface MutationValidation {
    boolean isMutant(DNA dna);
}
