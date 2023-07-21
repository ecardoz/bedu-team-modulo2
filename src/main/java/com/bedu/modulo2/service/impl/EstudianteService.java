package com.bedu.modulo2.service.impl;

import com.bedu.modulo2.dto.estudiante.EstudianteCreadoDto;
import com.bedu.modulo2.dto.estudiante.EstudianteDto;
import com.bedu.modulo2.dto.estudiante.EstudianteEliminadoDto;
import com.bedu.modulo2.dto.estudiante.EstudianteToUpdateDto;
import com.bedu.modulo2.exceptions.estudiante.EstudianteAlreadyExistsException;
import com.bedu.modulo2.exceptions.estudiante.EstudianteNotFoundException;
import com.bedu.modulo2.mapper.DireccionMapper;
import com.bedu.modulo2.mapper.EstudianteMapper;
import com.bedu.modulo2.model.Estudiante;
import com.bedu.modulo2.repository.EstudianteRepository;
import com.bedu.modulo2.service.IEstudianteService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Data
public class EstudianteService implements IEstudianteService {

    private final EstudianteRepository estudianteRepository;
    private final EstudianteMapper estudianteMapper;
    private final DireccionMapper direccionMapper;

    public EstudianteCreadoDto crearEstudiante(EstudianteDto estudianteDto) {
        if(estudianteRepository.existsByEmail(estudianteDto.email())
                || estudianteRepository.existsByCurp(estudianteDto.curp())){
            throw new EstudianteAlreadyExistsException("Ya existe un estudiante con el email o curp proporcionados.");
        }

        Estudiante estudiante = estudianteMapper.estudianteDtoToEstudiante(estudianteDto);
        return estudianteMapper.estudianteToEstudianteCreadoDto(estudianteRepository.save(estudiante));
    }

    public Page<EstudianteCreadoDto> obtenerEstudiantes(Pageable pageable) {
        Page<Estudiante> listaEstudiantes = estudianteRepository.findAllByActivoTrue(pageable);
        return listaEstudiantes.map(estudianteMapper::estudianteToEstudianteCreadoDto);
    }

    public EstudianteCreadoDto obtenerEstudiante(Long id) {
        Estudiante estudiante = estudianteRepository.getByIdAndActivoTrue(id);
        checkIsEstudianteNull(estudiante);
        return estudianteMapper.estudianteToEstudianteCreadoDto(estudiante);
    }

    public EstudianteCreadoDto obtenerEstudianteEmail(String email) {
        Estudiante estudiante = estudianteRepository.getByEmail(email);
        checkIsEstudianteNull(estudiante);
        return estudianteMapper.estudianteToEstudianteCreadoDto(estudiante);
    }

    public EstudianteEliminadoDto eliminarEstudiante(Long id) {
        Estudiante estudiante = estudianteRepository.getByIdAndActivoTrue(id);
        checkIsEstudianteNull(estudiante);
        estudiante.setActivo(false);
        return estudianteMapper.estudianteToEstudianteEliminadoDto(estudianteRepository.save(estudiante));
    }

    public EstudianteCreadoDto actualizarEstudiante(EstudianteToUpdateDto estudianteToUpdateDto) {
        Estudiante estudiante = estudianteRepository.getByIdAndActivoTrue(estudianteToUpdateDto.id());
        checkIsEstudianteNull(estudiante);
        estudiante.actualizar(estudianteToUpdateDto.nombreCompleto(), direccionMapper.direccionDtoToDireccion(estudianteToUpdateDto.direccion()));
        return estudianteMapper.estudianteToEstudianteCreadoDto(estudiante);
    }

    public void checkIsEstudianteNull(Estudiante estudiante) {
        if (estudiante == null)
            throw new EstudianteNotFoundException("No se encontró el estudiante");
    }
}
