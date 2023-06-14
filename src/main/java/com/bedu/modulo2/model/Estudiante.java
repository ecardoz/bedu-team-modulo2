package com.bedu.modulo2.model;

import jakarta.persistence.*;
import lombok.*;

/**Restricciones de la clase Estudiante:
 * - Id autoincremental
 * - Email unico
 * - Curp unico
 * */

@Entity
@Table(name="estudiantes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="nombre_completo", length = 100, nullable = false)
    private String nombreCompleto;

    @Column(unique = true, length = 50, nullable = false)
    private String email;

    @Column(unique = true, length = 50, nullable = false)
    private String curp;

    @Column(nullable = false)
    private Boolean activo;

    @Embedded
    private Direccion direccion;

    public void actualizar(String nombre, Direccion direccion) {
        if (nombre != null)
            this.nombreCompleto = nombre;

        if (direccion != null)
            this.direccion = this.direccion.actualizar(direccion);
    }
}
