package com.bedu.modulo2.dto.direccion;

import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

/**
 * DTO for {@link com.bedu.modulo2.model.Direccion}
 */
public record DireccionDto (
    @NotBlank(message = "La calle es requerida")
    String calle,
    @NotBlank(message = "El numero es requerido")
    String numero,
    @NotBlank(message = "La colonia es requerida")
    String colonia,
    @NotBlank(message = "El Codigo Postal es requerido")
    String codigoPostal,
    @NotBlank(message = "La ciudad es requerida")
    String ciudad,
    @NotBlank(message = "El estado es requerido")
    String estado

) implements Serializable {
}