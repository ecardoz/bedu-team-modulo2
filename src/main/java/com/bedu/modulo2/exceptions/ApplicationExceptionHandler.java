package com.bedu.modulo2.exceptions;

import com.bedu.modulo2.exceptions.estudiante.EstudianteNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Clase que se encarga de manejar las excepciones que se lanzan en la aplicación
 * */

@RestControllerAdvice
public class ApplicationExceptionHandler {

    /**Excepcion que se lanza cuando no existe un Estudiante en la BD*/
    @ExceptionHandler(EstudianteNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> medicoNotFoundException(EstudianteNotFoundException ex, HttpServletRequest req) {
        Map<String, String> errors = new HashMap<>(Map.of(ex.getClass().getSimpleName(), ex.getMessage()));
        ErrorResponseDto errorResponse = createResponse(HttpStatus.NOT_FOUND, req, errors);

        return ResponseEntity.status(404).body(errorResponse);
    }

    /**Excepción que se lanza cuando falla la validación de un argumento anotado con @Valid */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDto> methodArgumentNotValidException(MethodArgumentNotValidException ex, HttpServletRequest req) {
        Map<String, String> errors = ex.getFieldErrors().stream().collect(
          Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage)
        );

        ErrorResponseDto errorResponse = createResponse(HttpStatus.BAD_REQUEST, req, errors);
        return ResponseEntity.status(400).body(errorResponse);
    }

    /**Excepción que se lanza cuando un intento de insertar o actualizar datos resulta en la violación de una restricción de integridad
     * por ejemplo, si un campo no nulo va nulo, o si un campo es requerido y va en blanco, o campos unicos*/
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponseDto> dataIntegrityViolationException(DataIntegrityViolationException ex, HttpServletRequest req) {
        Map<String, String> errors = new HashMap<>(Map.of(ex.getClass().getSimpleName(), ex.getMessage()));
        ErrorResponseDto errorResponse = createResponse(HttpStatus.BAD_REQUEST, req, errors);
        return ResponseEntity.status(400).body(errorResponse);
    }

    /**
     * AGREGAR AQUI LOS METODOS PARA ATRAPAR LAS EXCEPCIONES QUE SE DEFINAN EN EL PROYECTO
     * YA SEA PARA ATRAPAR ERRORES DE VALIDACION, ERRORES DE NEGOCIO, ERRORES DE BD, ETC.
     * */

    /**Este metodo atrapa los errores genericos*/
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> genericException(Exception ex, HttpServletRequest req) {

        Map<String, String> errors = new HashMap<>(Map.of(ex.getClass().getSimpleName(), ex.getMessage()));
        ErrorResponseDto errorResponse = createResponse(HttpStatus.BAD_REQUEST, req, errors);
        return ResponseEntity.status(400).body(errorResponse);

    }

    /**Con este metodo se manda a crear el DTO que muestra el mensaje de error al cliente
     * @param status El estatus de la respuesta
     * @param req La petición HTTP
     * @param errors Mapa con los errores (en algunos casos pueden ser varios errores)
     * */
    private static ErrorResponseDto createResponse(
      HttpStatus status,
      HttpServletRequest req,
      Map<String, String> errors)
    {
        return new ErrorResponseDto(
          true, //Siempre se manda true porque es un error
          ZonedDateTime.now(), //La fecha y hora actual del error
          status.value(), //El código de error HTTP
          req.getRequestURI(), //La URI que se estaba solicitando
          errors //Los errores
        );
    }

}
