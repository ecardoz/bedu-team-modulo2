package com.bedu.modulo2.dto.estudiante;

import com.bedu.modulo2.dto.direccion.DireccionDto;
import com.bedu.modulo2.model.Direccion;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

/**
 * DTO for {@link com.bedu.modulo2.model.Estudiante}
 */
public record EstudianteCreadoDto (
      @NotNull(message = "El ID del estudiante es requerido")
      Long id,
      String nombreCompleto,
      String email,
      String curp,
      DireccionDto direccion

) implements Serializable {
}