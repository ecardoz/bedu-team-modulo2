package com.bedu.modulo2.service;

import com.bedu.modulo2.dto.curso.CursoCreadoDto;
import com.bedu.modulo2.dto.curso.CursoDto;
import com.bedu.modulo2.dto.estudiante.EstudianteCreadoDto;
import com.bedu.modulo2.dto.estudiante.EstudianteDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICursoService {
    public CursoCreadoDto crearCurso(CursoDto cursoDto);

    public Page<CursoCreadoDto> obtenerCursos(Pageable pageable);

    public Page<CursoCreadoDto> obtenerCursosEstudiante(Long id, Pageable pageable);
}
