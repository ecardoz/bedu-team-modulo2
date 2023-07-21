package com.bedu.modulo2.service.impl;

import com.bedu.modulo2.dto.curso.CursoCreadoDto;
import com.bedu.modulo2.dto.curso.CursoDto;
import com.bedu.modulo2.dto.estudiante.EstudianteCreadoDto;
import com.bedu.modulo2.dto.estudiante.EstudianteDto;
import com.bedu.modulo2.dto.materia.MateriaCreadaDto;
import com.bedu.modulo2.exceptions.estudiante.EstudianteAlreadyExistsException;
import com.bedu.modulo2.exceptions.materia.MateriaNotFoundException;
import com.bedu.modulo2.mapper.CursoMapper;
import com.bedu.modulo2.mapper.DireccionMapper;
import com.bedu.modulo2.mapper.EstudianteMapper;
import com.bedu.modulo2.model.Curso;
import com.bedu.modulo2.model.Estudiante;
import com.bedu.modulo2.model.Materia;
import com.bedu.modulo2.repository.CursoRepository;
import com.bedu.modulo2.repository.EstudianteRepository;
import com.bedu.modulo2.service.ICursoService;
import com.bedu.modulo2.service.IEstudianteService;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Data
public class CursoService implements ICursoService {

    private final CursoRepository cursoRepository;
    private final EstudianteMapper estudianteMapper;
    private final CursoMapper cursoMapper;

    public CursoCreadoDto crearCurso(CursoDto cursoDto){
        Curso curso = cursoMapper.cursoDtoToCurso(cursoDto);
        return  cursoMapper.cursoToCursoCreadoDto(cursoRepository.save(curso));
    }

    public Page<CursoCreadoDto> obtenerCursos(Pageable pageable) {
        Page<Curso> listaCursos = cursoRepository.findAll(pageable);
        return listaCursos.map(cursoMapper::cursoToCursoCreadoDto);
    }

    public Page<CursoCreadoDto> obtenerCursosEstudiante(Long id, Pageable pageable) {

        Page<Curso> listaCursos = cursoRepository.findAll(pageable);

        if (listaCursos.isEmpty()){
            throw new MateriaNotFoundException("No se encontraron registros de CURSOS");
        }

        return listaCursos.map(cursoMapper::cursoToCursoCreadoDto);
    }

}
