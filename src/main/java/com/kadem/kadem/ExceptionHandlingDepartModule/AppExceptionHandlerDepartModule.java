package com.kadem.kadem.ExceptionHandlingDepartModule;

import com.kadem.kadem.ExceptionHandling.InvalidIdException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandlerDepartModule {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidExceptionDepartModule.class)
    public String InvalidExceptionDepartModule( InvalidExceptionDepartModule ex)
    {
        return ex.getMessage();
    }
}
