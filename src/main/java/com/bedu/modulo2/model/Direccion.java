package com.bedu.modulo2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Direccion {
    @Column(length = 100, nullable = false)
    private String calle;
    @Column(length = 10, nullable = false)
    private String numero;
    @Column(length = 100, nullable = false)
    private String colonia;
    @Column(name = "codigo_postal", length = 100, nullable = false)
    private String codigoPostal;
    @Column(length = 50, nullable = false)
    private String ciudad;
    @Column(length = 100, nullable = false)
    private String estado;
}
