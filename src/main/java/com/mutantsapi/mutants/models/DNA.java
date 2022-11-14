package com.mutantsapi.mutants.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class DNA {

    @NotNull(message = "Must provide the person DNA code")
    @NotEmpty(message = "Must provide the person DNA code")
    @Size(min=4, message = "Must provide a longer DNA code")
    public String[] dna;

    public DNA (){}

    public DNA(String[] dna) {
        this.dna = dna;
    }
}
