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

    @Embedded
    private Direccion direccion;

}
