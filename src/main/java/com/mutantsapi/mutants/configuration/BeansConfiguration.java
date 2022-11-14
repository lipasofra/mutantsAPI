package com.mutantsapi.mutants.configuration;

import com.mutantsapi.mutants.services.PersonService;
import com.mutantsapi.mutants.services.validations.ValidateDimension;
import com.mutantsapi.mutants.services.validations.ValidateDimensionImplement;
import com.mutantsapi.mutants.services.validations.ValidateLetters;
import com.mutantsapi.mutants.services.validations.ValidateLettersImplement;
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

    @Bean
    public PersonService personService(){return new PersonService();}

}
