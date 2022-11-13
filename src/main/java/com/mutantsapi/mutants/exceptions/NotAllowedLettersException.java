package com.mutantsapi.mutants.exceptions;

public class NotAllowedLettersException extends RuntimeException {
    public NotAllowedLettersException(String message){
        super(message);
    }
}
