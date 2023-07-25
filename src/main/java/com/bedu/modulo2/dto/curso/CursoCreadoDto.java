package com.bedu.modulo2.dto.curso;

import com.bedu.modulo2.model.Estudiante;
import com.bedu.modulo2.model.Materia;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Map;

/**
 * DTO for {@link com.bedu.modulo2.model.Curso}
 */
public record CursoCreadoDto(
        @NotNull(message = "El ID del estudiante es requerido")
        Long id,
        String ciclo,
        Materia materia,
        Map<Estudiante, Integer> calificaciones
) implements Serializable {
}
