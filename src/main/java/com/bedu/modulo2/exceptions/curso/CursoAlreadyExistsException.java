package com.bedu.modulo2.exceptions.curso;

public class CursoAlreadyExistsException extends RuntimeException{

    public CursoAlreadyExistsException() {
        super();
    }

    public CursoAlreadyExistsException(String message) {
        super(message);
    }

    public CursoAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public CursoAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    protected CursoAlreadyExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
