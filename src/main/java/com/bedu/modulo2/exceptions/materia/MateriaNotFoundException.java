package com.bedu.modulo2.exceptions.materia;

public class MateriaNotFoundException extends RuntimeException{

    public MateriaNotFoundException() {
        super();
    }
    public MateriaNotFoundException(String message){
        super(message);
    }

    public MateriaNotFoundException(String message, Throwable cause){
        super(message, cause);
    }

    public MateriaNotFoundException(Throwable cause) {
        super(cause);
    }

    protected MateriaNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
