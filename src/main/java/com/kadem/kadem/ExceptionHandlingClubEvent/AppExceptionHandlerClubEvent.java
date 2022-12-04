package com.kadem.kadem.ExceptionHandlingClubEvent;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandlerClubEvent{

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidExceptionClubEvent.class)
    public String HandleInvalidIdException( InvalidExceptionClubEvent ex)
    {
        return ex.getMessage();
    }
}
