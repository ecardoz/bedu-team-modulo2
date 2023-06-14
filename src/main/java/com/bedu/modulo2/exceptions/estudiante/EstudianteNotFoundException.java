package com.bedu.modulo2.exceptions.estudiante;

public class EstudianteNotFoundException extends RuntimeException {

        public EstudianteNotFoundException() {
            super();
        }

        public EstudianteNotFoundException(String message) {
            super(message);
        }

        public EstudianteNotFoundException(String message, Throwable cause) {
            super(message, cause);
        }

        public EstudianteNotFoundException(Throwable cause) {
            super(cause);
        }

        protected EstudianteNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
            super(message, cause, enableSuppression, writableStackTrace);
        }
}
