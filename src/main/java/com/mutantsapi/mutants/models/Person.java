package com.mutantsapi.mutants.models;


import org.springframework.data.annotation.Id;
import javax.validation.constraints.NotBlank;

public class Person {

    @Id
    private String id;

    @NotBlank (message = "Must provide the person DNA code")
    private String[] dna;

    private Boolean isMutant;

    public Person() {
    }

    public Person(String[] dna, Boolean isMutant) {
        this.dna = dna;
        this.isMutant = isMutant;
    }

    public void setDna(String[] dna) {
        this.dna = dna;
    }

    public Boolean getIsMutant() {
        return isMutant;
    }

    public void setIsMutant(Boolean mutant) {
        isMutant = mutant;
    }

}
