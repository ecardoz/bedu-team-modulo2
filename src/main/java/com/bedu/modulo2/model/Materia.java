package com.bedu.modulo2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;


@Entity
@Table(name = "materias")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Materia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    @Size(max = 45)
    private String nombre;

    /*

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Return the subject name
     * @return
     * /
    public String getNombre() {
        return nombre;
    }

    /**
     * Set the subject name
     * @param nombre
     * /
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Materia(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Materia(){}

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
     */
}
