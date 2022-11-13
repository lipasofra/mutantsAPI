package com.mutantsapi.mutants.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
@ResponseBody
public class NotAllowedLettersAdvice {
    @ResponseBody
    @ExceptionHandler(NotAllowedLettersException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String EntityNotLettersAdvice(NotAllowedLettersException ex){return ex.getMessage();}
}
