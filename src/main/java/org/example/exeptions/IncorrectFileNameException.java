package org.example.exeptions;

public class IncorrectFileNameException extends Exception {
    public IncorrectFileNameException(String message, Throwable cause) {
        super(message, cause);
    }
}

