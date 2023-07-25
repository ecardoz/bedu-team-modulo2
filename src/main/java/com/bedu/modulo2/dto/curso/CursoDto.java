package com.bedu.modulo2.dto.curso;

import com.bedu.modulo2.model.Estudiante;
import com.bedu.modulo2.model.Materia;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;
import java.util.Map;

/**
 * DTO for {@link com.bedu.modulo2.model.Curso}
 */
public record CursoDto(

    @NotBlank(message = "Ciclo requerido")
    String ciclo,
    @NotBlank(message = "Materia requerida")
    Materia materia,
    @NotBlank(message = "Calificaciones requeridas")
    @Valid
    Map<Estudiante, Integer> calificaciones

) implements Serializable {
}
