package com.kadem.kadem.ExceptionHandlerForUnivAndEnseignant;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
public class AppExceptionHandlerUnivAndEnseignant {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidIdException.class)
    public String HandleInvalidException(InvalidIdException exception)
    {
        return exception.getMessage();
    }
}
