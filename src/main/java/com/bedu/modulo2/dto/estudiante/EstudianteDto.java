package com.bedu.modulo2.dto.estudiante;

import com.bedu.modulo2.dto.direccion.DireccionDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

/**
 * DTO for {@link com.bedu.modulo2.model.Estudiante}
 */
public record EstudianteDto (
    @NotBlank(message = "El nombre del estudiante no puede estar vacio")
    String nombreCompleto,
    @NotBlank(message = "El email no puede estar vacio")
    String email,
    @NotBlank(message = "El CURP del estudiante no puede estar vacio")
    String curp,
    @NotNull(message = "El estatus del estudiante no puede estar vacio")
    Boolean activo,
    @NotNull(message = "La Direccion completa es requerida")
    @Valid
    DireccionDto direccion

) implements Serializable {
}