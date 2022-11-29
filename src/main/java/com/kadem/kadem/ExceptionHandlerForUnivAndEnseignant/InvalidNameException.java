package com.kadem.kadem.ExceptionHandlerForUnivAndEnseignant;

public class InvalidNameException extends Exception {
    public InvalidNameException(String errorMessage)
    {
        super(errorMessage);
    }
}
