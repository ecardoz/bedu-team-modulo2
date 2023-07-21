package com.bedu.modulo2.model;

import jakarta.persistence.*;

import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ciclo;
    @ManyToOne
    private Materia materia;

    @ElementCollection
    @CollectionTable(name = "estudiantes_calificaciones", joinColumns = @JoinColumn(name = "curso_id"))
    @MapKeyJoinColumn(name = "estudiante_id")
    @Column(name = "calificacion")
    private Map<Estudiante, Integer> calificaciones = new HashMap<>();

    public Curso() {}

    public Curso(String ciclo, Materia materia) {
        this.ciclo = ciclo;
        this.materia = materia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public Materia getMateria() {
        return materia;
    }

    public String getMateriaNombre() {
        return materia.getNombre();
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Map<Estudiante, Integer> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(Map<Estudiante, Integer> calificaciones) {
        this.calificaciones = calificaciones;
    }

    public void agregarCalificacion(Estudiante estudiante, Integer calificacion) {
        this.calificaciones.put(estudiante, calificacion);
    }
}
