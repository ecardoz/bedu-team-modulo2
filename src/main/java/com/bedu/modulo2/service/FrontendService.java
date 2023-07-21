package com.bedu.modulo2.service;

import com.bedu.modulo2.dto.estudiante.EstudianteCreadoDto;
import com.bedu.modulo2.model.Curso;
import com.bedu.modulo2.model.Estudiante;
import com.bedu.modulo2.repository.CursoRepository;
import com.bedu.modulo2.repository.EstudianteRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class FrontendService {

    private final EstudianteRepository estudianteRepository;

    private final CursoRepository cursoRepository;
    public Estudiante obtenerEstudiante(Long id) {
        Estudiante estudiante = estudianteRepository.getByIdAndActivoTrue(id);
        return estudiante;
    }

    public Curso obtenetCurso(Long id){
        Curso curso = cursoRepository.getById(id);
        return  curso;
    }

    public List<Curso> obtenerCursos(){
        return cursoRepository.findAll();
    }
}
