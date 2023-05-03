package com.bedu.modulo2.tools;

import com.bedu.modulo2.model.Curso;
import com.bedu.modulo2.model.Estudiante;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ReporteCalificaciones {

    static class Reporte {
        private final String nombreEstudiante;
        private final Integer calificacion;

        public Reporte(String nombreEstudiante, Integer calificacion) {
            this.nombreEstudiante = nombreEstudiante;
            this.calificacion = calificacion;
        }

        public String getNombreEstudiante() {
            return nombreEstudiante;
        }

        public Integer getCalificacion() {
            return calificacion;
        }
    }


    public List<Reporte> alfabetico(Curso curso){
        return generaLista(
                curso.getCalificaciones(), Comparator.comparing(Reporte::getNombreEstudiante));
    }

    public List<Reporte> calificacion(Curso curso){
        return generaLista(
                curso.getCalificaciones(), Comparator.comparing(Reporte::getCalificacion).reversed());
    }

    private List<Reporte> generaLista(Map<Estudiante, Integer> calificaciones, Comparator<Reporte> comparator){
        return calificaciones.entrySet().stream()
                .map(e -> new Reporte(e.getKey().getNombreCompleto(), e.getValue()))
                .sorted(comparator)
                .collect(Collectors.toList());
    }
}
