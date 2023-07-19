package com.bedu.modulo2.controller;

import com.bedu.modulo2.dto.estudiante.EstudianteCreadoDto;
import com.bedu.modulo2.dto.materia.MateriaCreadaDto;
import com.bedu.modulo2.dto.materia.MateriaDto;
import com.bedu.modulo2.model.Estudiante;
import com.bedu.modulo2.service.IEstudianteService;
import com.bedu.modulo2.service.IMateriaService;
import com.bedu.modulo2.service.impl.EstudianteService;
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

@Controller
@Data
public class FrontendController {

    private final IEstudianteService estudianteService;
    private final IMateriaService materiaService;
    @GetMapping({"/", "/index"})
    public String inicioSesión(Model model) {
        model.addAttribute("estudiante", new Estudiante());

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
            //agendaService.guardaPersona(persona);
            estudiante1 = estudianteService.obtenerEstudianteEmail(estudiante.getEmail());
        }
        Pageable pageable = PageRequest.of(0,10);

        Page<MateriaCreadaDto> listaCursos = materiaService.obtenerMaterias(pageable);

        ModelAndView mav = new ModelAndView(vistaResultado);
        mav.addObject("estudiante", estudiante1);
        mav.addObject("listaCursos", listaCursos);
        mav.addObject("mensajeConfirmacion", mensajeConfirmacion);
        return mav;
    }

    @GetMapping("/curso/{id}")
    public ModelAndView detalleCurso(@PathVariable Long id){
        ModelAndView mav = new ModelAndView("detalleCurso");
        //mav.addObject("mensajeConfirmacion", "El contacto ha sido eliminado");
        //agendaService.deletePersona(id);
        //mav.addObject("listaPersonas", agendaService.getPersonas());
        return mav;
    }
}
