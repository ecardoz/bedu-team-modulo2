package com.bedu.modulo2.exceptions;

import java.time.ZonedDateTime;
import java.util.Map;

/**
 * Clase que representa la estructura de una respuesta de error.
 * */

public record ErrorResponseDto(
      Boolean isError,
      ZonedDateTime timestamp,
      Integer statusCode,
      String path,
      Map<String, String> messages ) {
}
