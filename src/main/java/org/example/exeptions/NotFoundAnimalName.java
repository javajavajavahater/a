package org.example.exeptions;

public class NotFoundAnimalName extends Exception {
    public NotFoundAnimalName(String message, Throwable cause) {
        super(message, cause);
    }
}
