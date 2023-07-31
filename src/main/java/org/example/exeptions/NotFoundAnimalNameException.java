package org.example.exeptions;

public class NotFoundAnimalNameException extends Exception {
    public NotFoundAnimalNameException(String message, Throwable cause) {
        super(message, cause);
    }
}
