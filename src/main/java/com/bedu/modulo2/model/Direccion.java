package com.bedu.modulo2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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

    public Direccion actualizar(Direccion direccion) {
        if (direccion.getCalle() != null && !direccion.getCalle().isEmpty())
            this.calle = direccion.getCalle();

        if (direccion.getNumero() != null && !direccion.getNumero().isEmpty())
            this.numero = direccion.getNumero();

        if (direccion.getColonia() != null && !direccion.getColonia().isEmpty())
            this.colonia = direccion.getColonia();

        if (direccion.getCodigoPostal() != null && !direccion.getCodigoPostal().isEmpty())
            this.codigoPostal = direccion.getCodigoPostal();

        if (direccion.getCiudad() != null && !direccion.getCiudad().isEmpty())
            this.ciudad = direccion.getCiudad();

        if (direccion.getEstado() != null && !direccion.getEstado().isEmpty())
            this.estado = direccion.getEstado();

        return this;
    }
}
