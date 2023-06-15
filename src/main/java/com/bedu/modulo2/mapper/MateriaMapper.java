package com.bedu.modulo2.mapper;

import com.bedu.modulo2.dto.materia.MateriaCreadaDto;
import com.bedu.modulo2.dto.materia.MateriaEliminadaDto;
import com.bedu.modulo2.dto.materia.MateriaDto;
import com.bedu.modulo2.model.Materia;
import org.mapstruct.*;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {DireccionMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE )
public interface MateriaMapper {

    @Mapping(source = "nombreMateria", target = "nombre")

    Materia materiaDtoToMateria(MateriaDto materiaDto);

    @Mapping(source = "nombre", target = "nombreMateria")
    MateriaCreadaDto materiaToMateriaCreadaDto(Materia materia);

    MateriaEliminadaDto materiaToMateriaEliminadaDto(Materia materia);
}
