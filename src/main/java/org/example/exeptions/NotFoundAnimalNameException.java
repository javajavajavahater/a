package org.example.exeptions;

public class NotFoundAnimalNameException extends AnimalException {
    public NotFoundAnimalNameException(String message, Throwable cause) {
        super(message, cause);
    }
}
