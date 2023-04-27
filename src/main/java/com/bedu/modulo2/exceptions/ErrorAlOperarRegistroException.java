package com.bedu.modulo2.exceptions;

public class ErrorAlOperarRegistroException extends RuntimeException {
    public ErrorAlOperarRegistroException(String message) {
        super(message);
    }

    public ErrorAlOperarRegistroException(String message, Throwable cause) {
        super(message, cause);
    }
}
