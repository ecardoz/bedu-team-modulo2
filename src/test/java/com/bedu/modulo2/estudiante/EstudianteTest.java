package com.bedu.modulo2.estudiante;

import com.bedu.modulo2.model.Estudiante;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class EstudianteTest {

    @Test
    public void createStudentTest(){
        Estudiante student = new Estudiante();
        String nombreStudent = "Jhon Wick";
        student.setNombreCompleto(nombreStudent);
        assertThat(student.getNombreCompleto()).isEqualTo(nombreStudent);
    }

    @Test
    @Disabled("TODO")
    public void createAndStoreStudentTest(){
        Estudiante student = new Estudiante();
        String nombreStudent = "Jhon Wick";
        student.setNombreCompleto(nombreStudent);
        assertThat(student.getNombreCompleto()).isEqualTo(nombreStudent);
    }
}
