package com.bedu.modulo2.dto.estudiante;

import com.bedu.modulo2.dto.direccion.DireccionDto;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

/**
 * DTO for {@link com.bedu.modulo2.model.Estudiante}
 */
public record EstudianteToUpdateDto (
      @NotNull(message = "El ID del estudiante es requerido para la actualizacion")
      Long id,
      String nombreCompleto,
      DireccionDto direccion

) implements Serializable {
}