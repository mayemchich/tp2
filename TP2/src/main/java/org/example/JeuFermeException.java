package org.example;

public class JeuFermeException extends Exception {
    // Constructeur avec un message d'erreur
    public JeuFermeException(String message) {
        super(message);
    }

    // Constructeur avec un message d'erreur et une cause
    public JeuFermeException(String message, Throwable cause) {
        super(message, cause);
    }
}

