package com.bedu.modulo2.controller;

import com.bedu.modulo2.dto.estudiante.EstudianteCreadoDto;
import com.bedu.modulo2.dto.materia.MateriaCreadaDto;
import com.bedu.modulo2.exceptions.estudiante.EstudianteNotFoundException;
import com.bedu.modulo2.model.Curso;
import com.bedu.modulo2.model.Estudiante;
import com.bedu.modulo2.model.Materia;
import com.bedu.modulo2.service.FrontendService;
import com.bedu.modulo2.service.IEstudianteService;
import com.bedu.modulo2.service.IMateriaService;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
@Data
public class FrontendController {

    private final IEstudianteService estudianteService;
    private final IMateriaService materiaService;

    private final FrontendService service;

    private List<Curso> cursosList = null;

    private void todosMisCursos(){
        Pageable pageable = PageRequest.of(0,10);
        Page<MateriaCreadaDto> materias = materiaService.obtenerMaterias(pageable);

        cursosList = new LinkedList<>();


        Curso curso = null;
        Long index = 1L;
        for(MateriaCreadaDto m: materias){
            curso = new Curso("2022-2023", new Materia(m.nombreMateria()) );
            curso.setId(index);
            cursosList.add(curso);
            index+=1;
        }

    }

    private void agregarCalificacionEstudiante(EstudianteCreadoDto estudiante){
        int calificacion;
        Estudiante estudiante1 =  service.obtenerEstudiante(estudiante.id());

        for(Curso curso: cursosList){
            calificacion = (int) (Math.random()*(10-8+1)+8);
            curso.agregarCalificacion(estudiante1, calificacion);
        }
    }

    @GetMapping({"/", "/index"})
    public String inicioSesión(Model model) {
        model.addAttribute("estudiante", new Estudiante());
        todosMisCursos();

        return "index";
    }

    @PostMapping("/sesionestudiante")
    public ModelAndView registra(@Valid Estudiante estudiante, Errors errors) {
        String vistaResultado = "perfilEstudiante";
        String mensajeConfirmacion = "Sesión iniciada";

        EstudianteCreadoDto estudiante1 = null;
        if (errors.hasErrors()) {
            vistaResultado = "index";
            mensajeConfirmacion = "Estudiante no encontrado";
        }else{

            try {
                estudiante1 = estudianteService.obtenerEstudianteEmail(estudiante.getEmail());
                //TBD
                agregarCalificacionEstudiante(estudiante1);
            } catch (EstudianteNotFoundException e){
                vistaResultado = "index";
                mensajeConfirmacion = "Estudiante no encontrado";
            }
        }


        ModelAndView mav = new ModelAndView(vistaResultado);
        if (estudiante1 != null){
            mav.addObject("estudiante", estudiante1);
            mav.addObject("listaCursos", cursosList);
        }
        mav.addObject("mensajeConfirmacion", mensajeConfirmacion);
        return mav;
    }

    @PostMapping("/misDatos")
    public ModelAndView datosEstudiante(EstudianteCreadoDto estudiante) {
        ModelAndView mav = new ModelAndView("misDatos");
        if (estudiante != null) {
            mav.addObject("estudiante", estudiante);
        }

        return  mav;
    }

    @GetMapping("/curso/{id}")
    public ModelAndView detalleCurso(@PathVariable Long id){
        ModelAndView mav = new ModelAndView("detalleCurso");

        Curso curso = cursosList.get(id.intValue() - 1);
        if (curso != null) {
            Materia materia = curso.getMateria();
            String nombreMateria = materia.getNombre();

            Estudiante estudiante = (Estudiante) curso.getCalificaciones().keySet().toArray()[0];
            Integer calificacion = curso.getCalificaciones().get(estudiante);

            mav.addObject("estudiante", estudiante);
            mav.addObject("materia", nombreMateria);
            mav.addObject("calificacion", calificacion);
        }
        return mav;
    }


}
