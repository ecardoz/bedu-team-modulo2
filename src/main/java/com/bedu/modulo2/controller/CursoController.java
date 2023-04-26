package com.bedu.modulo2.controller;

import com.bedu.modulo2.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/curso")
public class CursoController {
    private final CursoService cursoService;
    private final EstudianteService estudianteService;

    @Autowired
    public CursoController(CursoService cursoService, EstudianteService estudianteService) {
        this.cursoService = cursoService;
        this.estudianteService = estudianteService;
    }
}
