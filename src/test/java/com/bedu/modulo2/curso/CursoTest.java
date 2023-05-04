package com.bedu.modulo2.curso;

import com.bedu.modulo2.model.Curso;
import com.bedu.modulo2.model.Estudiante;
import com.bedu.modulo2.model.Materia;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class CursoTest {

    @Test
    public void createCursoTest(){
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

        assertThat(curse.getCiclo()).isEqualTo("Semestre 1");
        assertThat(curse.getMateria()).isEqualTo(subject1);
        assertThat(curse.getCalificaciones()).isEqualTo(map);
    }

}
