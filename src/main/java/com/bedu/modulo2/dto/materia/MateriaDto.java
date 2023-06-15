package com.bedu.modulo2.dto.materia;

import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

/**
 * DTO for {@link com.bedu.modulo2.model.Materia}
 */

public record MateriaDto(
        @NotBlank(message = "El nombre de la materia no puede estar vacío")
        String nombreMateria

) implements Serializable {
}
