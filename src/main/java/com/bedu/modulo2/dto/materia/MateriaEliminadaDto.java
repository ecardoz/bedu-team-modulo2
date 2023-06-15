package com.bedu.modulo2.dto.materia;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

public record MateriaEliminadaDto(
        @NotNull(message = "El ID de la materia es requerido")
        Long id,
        String nombreMateria
) implements Serializable {
}
