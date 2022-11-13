package com.mutantsapi.mutants.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody
public class NotEqualDimensionsAdvice {
    @ResponseBody
    @ExceptionHandler(NotEqualDimensionsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String EntityNotDimensionsAdvice(NotEqualDimensionsException ex){return ex.getMessage();}
}
