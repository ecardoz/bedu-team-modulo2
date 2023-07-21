package com.bedu.modulo2.mapper;

import com.bedu.modulo2.dto.curso.CursoCreadoDto;
import com.bedu.modulo2.dto.curso.CursoDto;
import com.bedu.modulo2.dto.estudiante.EstudianteCreadoDto;
import com.bedu.modulo2.dto.estudiante.EstudianteDto;
import com.bedu.modulo2.dto.estudiante.EstudianteEliminadoDto;
import com.bedu.modulo2.dto.estudiante.EstudianteToUpdateDto;
import com.bedu.modulo2.model.Curso;
import com.bedu.modulo2.model.Estudiante;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {DireccionMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE )

//@Component
public interface CursoMapper {
    Curso cursoDtoToCurso(CursoDto cursoDto);

    CursoDto cursoToCursoDto(Curso curso);

    Estudiante estudianteCreadoDtoToEstudiante(EstudianteCreadoDto estudianteCreadoDto);

    CursoCreadoDto cursoToCursoCreadoDto(Curso curso);

}