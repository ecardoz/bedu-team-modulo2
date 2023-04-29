package com.bedu.modulo2.multithreading;

import com.bedu.modulo2.model.Curso;

public class CalculadorPromedioCurso implements Runnable{

    private Curso curso;
    private double promedio;

    public CalculadorPromedioCurso(Curso curso){
        this.curso = curso;
    }

    @Override
    public void run(){
        int nAlumnos = 0;
        for(Integer i: curso.getCalificaciones().values()){
            promedio += i;
            nAlumnos++;
        }

        promedio /= nAlumnos;

        System.out.println(String.format("El promedio del curso: %s - %s es: %s",
                curso.getId(), curso.getMateria().getNombre(), promedio));
    }
}
