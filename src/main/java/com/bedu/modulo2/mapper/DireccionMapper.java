package com.bedu.modulo2.mapper;

import com.bedu.modulo2.dto.direccion.DireccionDto;
import com.bedu.modulo2.model.Direccion;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

@Component
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface DireccionMapper {
    Direccion direccionDtoToDireccion(DireccionDto direccionDto);

    DireccionDto direccionToDireccionDto(Direccion direccion);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Direccion partialUpdate(DireccionDto direccionDto, @MappingTarget Direccion direccion);
}