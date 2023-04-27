package com.bedu.modulo2.exceptions;

public class RegistroInvalidoException extends RuntimeException {
    public RegistroInvalidoException(String message) {
        super(message);
    }

    public RegistroInvalidoException(String message, Throwable cause) {
        super(message, cause);
    }
}
