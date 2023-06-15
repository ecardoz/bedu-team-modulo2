package com.bedu.modulo2.service.impl;

import com.bedu.modulo2.dto.materia.MateriaCreadaDto;
import com.bedu.modulo2.dto.materia.MateriaDto;
import com.bedu.modulo2.dto.materia.MateriaToUpdateDto;
import com.bedu.modulo2.exceptions.materia.MateriaNotFoundException;
import com.bedu.modulo2.mapper.MateriaMapper;
import com.bedu.modulo2.model.Materia;
import com.bedu.modulo2.repository.MateriaRepository;
import com.bedu.modulo2.service.IMateriaService;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Data
public class MateriaService implements IMateriaService {

    private final MateriaRepository materiaRepository;
    private final MateriaMapper materiaMapper;

    public MateriaCreadaDto crearMateria(MateriaDto materiaDto){
        Materia materia = materiaMapper.materiaDtoToMateria(materiaDto);
        return materiaMapper.materiaToMateriaCreadaDto(materiaRepository.save(materia));
    }

    public Page<MateriaCreadaDto> obtenerMaterias(Pageable pageable){
        Page<Materia> listaMaterias = materiaRepository.findAll(pageable);

        if (listaMaterias.isEmpty()){
            throw new MateriaNotFoundException("No se encontraron registros de materias");
        }

        return listaMaterias.map(materiaMapper::materiaToMateriaCreadaDto);
    }

    public MateriaCreadaDto obtenerMateria(Long id){
        Materia materia = materiaRepository.getById(id);
        checkIsMateriaNull(materia);
        return materiaMapper.materiaToMateriaCreadaDto(materia);
    }

    public void eliminarMateria(Long id){
        Materia materia = materiaRepository.getById(id);
        checkIsMateriaNull(materia);
        materiaRepository.delete(materia);
        //return materiaMapper.materiaToMateriaEliminadaDto(materiaRepository.save(materia));
    }

    public MateriaCreadaDto actualizarMateria(MateriaToUpdateDto materiaToUpdateDto){
        Materia materia = materiaRepository.getById(materiaToUpdateDto.id());
        checkIsMateriaNull(materia);
        materia.setNombre(materiaToUpdateDto.nombreMateria());
        return materiaMapper.materiaToMateriaCreadaDto(materia);
    }

    public void checkIsMateriaNull(Materia materia){
        if (materia == null){
            throw new MateriaNotFoundException("No se encontró registro de la materia");
        }
    }
}
