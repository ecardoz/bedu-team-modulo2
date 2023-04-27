package com.bedu.modulo2.dto;

import com.bedu.modulo2.model.Curso;

public class CalificacionDTO {

    private Curso curso;
    private Estudiante estudiante;
    private Integer calificacion;

    public Curso getCurso() {
        return curso;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public Integer getCalificacion() {
        return calificacion;
    }
}