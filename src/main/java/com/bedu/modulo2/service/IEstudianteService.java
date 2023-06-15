package com.bedu.modulo2.service;

import com.bedu.modulo2.dto.estudiante.EstudianteCreadoDto;
import com.bedu.modulo2.dto.estudiante.EstudianteDto;
import com.bedu.modulo2.dto.estudiante.EstudianteEliminadoDto;
import com.bedu.modulo2.dto.estudiante.EstudianteToUpdateDto;
import com.bedu.modulo2.model.Estudiante;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEstudianteService {
    public EstudianteCreadoDto crearEstudiante(EstudianteDto estudianteDto);

    public Page<EstudianteCreadoDto> obtenerEstudiantes(Pageable pageable);

    public EstudianteCreadoDto obtenerEstudiante(Long id);

    public EstudianteEliminadoDto eliminarEstudiante(Long id);

    public EstudianteCreadoDto actualizarEstudiante(EstudianteToUpdateDto estudianteToUpdateDto);

    public void checkIsEstudianteNull(Estudiante estudiante);
}
