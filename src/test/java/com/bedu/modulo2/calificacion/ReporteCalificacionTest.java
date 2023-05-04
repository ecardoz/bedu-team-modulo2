package com.bedu.modulo2.calificacion;

import com.bedu.modulo2.model.Curso;
import com.bedu.modulo2.model.Estudiante;
import com.bedu.modulo2.model.Materia;
import com.bedu.modulo2.tools.ReporteCalificaciones;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.LIST;

public class ReporteCalificacionTest {

    @Test
    public void reporteCalificacionTest(){

        Estudiante student1 = new Estudiante();
        student1.setNombreCompleto("Tony Stark");
        Estudiante student2 = new Estudiante();
        student2.setNombreCompleto("Wanda Maximoff");

        Materia subject1 = new Materia();
        subject1.setNombre("English");
        Materia subject2 = new Materia();
        subject2.setNombre("Maths");

        Curso curse = new Curso();
        curse.setCiclo("Semestre 1");
        curse.setMateria(subject1);

        Map<Estudiante, Integer> map = new HashMap<>();
        map.put(student1, 99);
        curse.setCalificaciones(map);

        ReporteCalificaciones reporteCalificaciones = new ReporteCalificaciones();

        reporteCalificaciones.calificacion(curse);

        assertThat(reporteCalificaciones.calificacion(curse));
        assertThat(reporteCalificaciones.alfabetico(curse));
    }
}
