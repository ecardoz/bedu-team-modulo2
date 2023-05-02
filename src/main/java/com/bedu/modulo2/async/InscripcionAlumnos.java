package com.bedu.modulo2.async;

import com.bedu.modulo2.model.Curso;
import com.bedu.modulo2.model.Estudiante;
import com.bedu.modulo2.model.Materia;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class InscripcionAlumnos {
    public static void main(String[] args) {

        ReceptorSolicitudes eventLoop = new ReceptorSolicitudes(solicitudInscripcion -> {
            if (solicitudInscripcion.getEstudiante() == null || solicitudInscripcion.getCurso() == null){
                System.out.println("Solicitud rechazdas, los datos son incorrectos");
            }

            System.out.println("Un nuevo alumno de inscribió al curso");
            System.out.println(String.format("El estudiante: [%s] se ha inscrito en la materia %s",
                    solicitudInscripcion.getEstudiante().getNombreCompleto(),
                    solicitudInscripcion.getCurso().getMateria().getNombre()));
        });

        eventLoop.iniciar();

        //Solicitudes
        SolicitudEstudiante[] solicitudes = crearSolicitudes();
        for(SolicitudEstudiante solicitud: solicitudes){
            eventLoop.registraSolicitud(solicitud);
            try{
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        eventLoop.detener();

    }

    private static SolicitudEstudiante[] crearSolicitudes(){
        Curso[] cursos = new Curso[]{
                crearCurso("Gestión de base de datos", 1),
                crearCurso("Multi Hilos y procesos", 2),
                crearCurso("Programación Funcional", 3),
                crearCurso("Procesos asíncronos", 4)
        };

        SolicitudEstudiante[] solicitudes = new SolicitudEstudiante[20];
        int nEstudiante;
        for(int i=0; i< 20; i++){
            nEstudiante=i+1;
            Estudiante e = new Estudiante();
            e.setNombreCompleto("Estudiante " + nEstudiante);
            e.setId((long)i);

            solicitudes[i] = new SolicitudEstudiante(e, cursos[Math.floorMod(i,4)]);
        }

        return solicitudes;
    }

    private static Curso crearCurso(String nombreMateria, long idCurso){
        Curso curso = new Curso();
        Materia materia = new Materia();
        materia.setNombre(nombreMateria);
        curso.setMateria(materia);

        return curso;
    }
}
