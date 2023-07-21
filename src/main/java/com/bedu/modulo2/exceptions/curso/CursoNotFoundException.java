package com.bedu.modulo2.exceptions.curso;

public class CursoNotFoundException extends RuntimeException {

    public CursoNotFoundException() {
        super();
    }

    public CursoNotFoundException(String message) {
        super(message);
    }

    public CursoNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CursoNotFoundException(Throwable cause) {
        super(cause);
    }

    protected CursoNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
