package com.bedu.modulo2.multithreading;

import com.bedu.modulo2.model.Curso;
import com.bedu.modulo2.model.Estudiante;
import com.bedu.modulo2.model.Materia;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Postwork2 {

    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        Curso[] cursos = new Curso[]{
                crearCurso("Gestión de base de datos", 1),
                crearCurso("Multi Hilos y procesos", 2),
                crearCurso("Programación Funcional", 3),
                crearCurso("Procesos asíncronos", 4)
        };

        for(Curso curso: cursos){
            pool.execute(new CalculadorPromedioCurso(curso));
        }

        pool.shutdown();
    }

    private static Curso crearCurso(String nombreMateria, long idCurso){
        Curso curso = new Curso();
        Materia materia = new Materia();
        materia.setNombre(nombreMateria);
        curso.setMateria(materia);

        Map<Estudiante, Integer> calificaciones = new HashMap<>();
        Random rm;
        for(int i=0; i<20; i++){
            Estudiante estudiante = new Estudiante();
            estudiante.setId((long)i);
            estudiante.setNombreCompleto("Estudiante " + i);
            rm = new Random();
            calificaciones.put(estudiante,rm.nextInt(10));
        }

        curso.setCalificaciones(calificaciones);
        return curso;
    }
}
