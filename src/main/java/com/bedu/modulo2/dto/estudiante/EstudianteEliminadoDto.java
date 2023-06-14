package com.bedu.modulo2.dto.estudiante;

import java.io.Serializable;

/**
 * DTO for {@link com.bedu.modulo2.model.Estudiante}
 */
public record EstudianteEliminadoDto (
    Long id,
    Boolean activo,
    String nombreCompleto,
    String email,
    String curp

) implements Serializable {
}