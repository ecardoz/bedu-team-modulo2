package com.bedu.modulo2.service;

import com.bedu.modulo2.dto.materia.MateriaCreadaDto;
import com.bedu.modulo2.dto.materia.MateriaDto;
import com.bedu.modulo2.dto.materia.MateriaToUpdateDto;
import com.bedu.modulo2.model.Materia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IMateriaService {

    public MateriaCreadaDto crearMateria(MateriaDto materiaDto);

    public Page<MateriaCreadaDto> obtenerMaterias(Pageable pageable);

    public MateriaCreadaDto obtenerMateria(Long id);

    public void eliminarMateria(Long id);

    public MateriaCreadaDto actualizarMateria(MateriaToUpdateDto materiaToUpdateDto);

    public void checkIsMateriaNull(Materia materia);

}
