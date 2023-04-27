package com.bedu.modulo2.exceptions;

public class RegistroExistenteException extends RuntimeException {
    public RegistroExistenteException(String message) {
        super(message);
    }

    public RegistroExistenteException(String message, Throwable cause) {
        super(message, cause);
    }
}
