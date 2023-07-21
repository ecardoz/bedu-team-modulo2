package com.bedu.modulo2.dto.curso;

import com.bedu.modulo2.dto.direccion.DireccionDto;
import com.bedu.modulo2.model.Estudiante;
import com.bedu.modulo2.model.Materia;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.HashMap;
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
