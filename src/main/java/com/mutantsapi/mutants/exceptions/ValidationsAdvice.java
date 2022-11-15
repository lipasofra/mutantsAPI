package com.mutantsapi.mutants.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
@ResponseBody
public class ValidationsAdvice {

    @ResponseBody
    @ExceptionHandler(ValidationsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String EntityAdvice(ValidationsException ex){return ex.getMessage();}
}
