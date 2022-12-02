package com.kadem.kadem.ExceptionHandlerForUnivAndEnseignant;

public class InvalidIdException extends Exception {
    public InvalidIdException(String errorMessage)
    {
        super(errorMessage);
    }
}
