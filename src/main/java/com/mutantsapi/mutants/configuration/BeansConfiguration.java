package com.mutantsapi.mutants.configuration;

import com.mutantsapi.mutants.models.dtos.ValidateDimension;
import com.mutantsapi.mutants.models.dtos.ValidateDimensionImplement;
import com.mutantsapi.mutants.models.dtos.ValidateLetters;
import com.mutantsapi.mutants.models.dtos.ValidateLettersImplement;
import com.mutantsapi.mutants.repositories.PersonRepository;
import com.mutantsapi.mutants.services.MutationValidation;
import com.mutantsapi.mutants.services.MutationValidationImp;
import com.mutantsapi.mutants.services.searches.Searches;
import com.mutantsapi.mutants.services.searches.SearchesImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfiguration {

    @Bean
    public MutationValidation mutationValidation(ValidateDimension validateDimension, ValidateLetters validateLetters
            , Searches searches){
        return new MutationValidationImp(validateDimension, validateLetters, searches);
    }

    @Bean
    public ValidateLetters validateLetters(){
        return new ValidateLettersImplement();
    }

    @Bean
    public ValidateDimension validateDimension(){
        return new ValidateDimensionImplement();
    }

    @Bean
    public Searches searches(){
        return new SearchesImpl();
    }
}
