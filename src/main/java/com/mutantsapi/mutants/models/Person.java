package com.mutantsapi.mutants.models;

import com.sun.istack.NotNull;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;

public class Person {

    @Id
    private String id;

    @NotBlank (message = "Must provide the person DNA code")
    private DNA dna;

    private Boolean isMutant;

    public Person(DNA dna, Boolean isMutant) {
        this.dna = dna;
        this.isMutant = isMutant;
    }

    public void setDna(DNA dna) {
        this.dna = dna;
    }

    public Boolean getIsMutant() {
        return isMutant;
    }

    public void setIsMutant(Boolean mutant) {
        isMutant = mutant;
    }

}
