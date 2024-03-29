package com.bedu.modulo2.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class ReceptorSolicitudes implements Runnable{

    private static final Logger logger = LoggerFactory.getLogger(InscripcionAlumnos.class);

    private boolean enEjecucion = false;
    private Queue<SolicitudEstudiante> listaSolicitudes = new LinkedList<>();
    private final NotificadorInscripcion notificationWorker;

    public ReceptorSolicitudes(NotificadorInscripcion notificationWorker){
        this.notificationWorker = notificationWorker;
    }
    @Override
    public void run() {
        try{
            while(enEjecucion || !listaSolicitudes.isEmpty()){
                SolicitudEstudiante evento = listaSolicitudes.poll();

                if (evento == null){
                    logger.info("No hay solicitudes pendientes.");
                    TimeUnit.SECONDS.sleep(1);
                    continue;
                }
                notificationWorker.notificar(evento);
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e){
            enEjecucion = false;
            e.printStackTrace();
        }

    }

    public void iniciar(){
        this.enEjecucion = true;
        new Thread(this).start();
    }

    public void detener(){
        this.enEjecucion = false;
    }

    public void registraSolicitud(SolicitudEstudiante evento){
        listaSolicitudes.add(evento);
    }

    public boolean isEnEjecucion() {
        return enEjecucion;
    }
}
