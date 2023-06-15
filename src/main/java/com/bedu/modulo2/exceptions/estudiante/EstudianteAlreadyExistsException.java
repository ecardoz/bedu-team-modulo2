package com.bedu.modulo2.exceptions.estudiante;

public class EstudianteAlreadyExistsException extends RuntimeException {

        public EstudianteAlreadyExistsException() {
            super();
        }

        public EstudianteAlreadyExistsException(String message) {
            super(message);
        }

        public EstudianteAlreadyExistsException(String message, Throwable cause) {
            super(message, cause);
        }

        public EstudianteAlreadyExistsException(Throwable cause) {
            super(cause);
        }

        protected EstudianteAlreadyExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
            super(message, cause, enableSuppression, writableStackTrace);
        }
}
