package com.bedu.modulo2.mapper;

import com.bedu.modulo2.dto.estudiante.EstudianteCreadoDto;
import com.bedu.modulo2.dto.estudiante.EstudianteDto;
import com.bedu.modulo2.dto.estudiante.EstudianteEliminadoDto;
import com.bedu.modulo2.dto.estudiante.EstudianteToUpdateDto;
import com.bedu.modulo2.model.Estudiante;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

@Mapper(
  unmappedTargetPolicy = ReportingPolicy.IGNORE,
  componentModel = MappingConstants.ComponentModel.SPRING,
  uses = {DireccionMapper.class},
  nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE )

@Component
public interface EstudianteMapper {
    Estudiante estudianteDtoToEstudiante(EstudianteDto estudianteDto);

    EstudianteDto estudiantetoEstudianteDto(Estudiante estudiante);

    Estudiante estudianteCreadoDtoToEstudiante(EstudianteCreadoDto estudianteCreadoDto);

    EstudianteCreadoDto estudianteToEstudianteCreadoDto(Estudiante estudiante);

    Estudiante estudianteEliminadoDtoToEstudiante(EstudianteEliminadoDto estudianteEliminadoDto);

    EstudianteEliminadoDto estudianteToEstudianteEliminadoDto(Estudiante estudiante);

    Estudiante estudianteToUpdateDtoToEstudiante(EstudianteToUpdateDto estudianteToUpdateDto);

    EstudianteToUpdateDto estudianteToEstudianteToUpdateDto(Estudiante estudiante);
}