package com.mutantsapi.mutants.models;

public class Person {

    private String id;
    private String[] dna;
    private Boolean isMutant;

    public Person(String[] dna, Boolean isMutant, String id) {
        this.id = id;
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
