package org.example;

public class DebitImpossibleException extends Exception {
    // Constructeur avec un message d'erreur
    public DebitImpossibleException(String message) {
        super(message);
    }

    // Constructeur avec un message d'erreur et une cause
    public DebitImpossibleException(String message, Throwable cause) {
        super(message, cause);
    }
}