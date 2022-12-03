package com.kadem.kadem.ExceptionHandlingEtudiantContrat;

import com.kadem.kadem.ExceptionHandling.InvalidIdException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandlerEtudiantContrat {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidExceptionEtudiantContrat.class)
    public String InvalidExceptionEtudiantContrat( InvalidExceptionEtudiantContrat ex)
    {
        return ex.getMessage();
    }
}
