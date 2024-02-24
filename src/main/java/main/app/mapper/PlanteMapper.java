package main.app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import main.app.dto.PlanteDto;
import main.app.entities.Plante;


@Mapper(componentModel = "spring")
public interface PlanteMapper {
    PlanteMapper INSTANCE = Mappers.getMapper(PlanteMapper.class);

    @Mapping(target = "id", ignore = true)
    Plante toPlante(PlanteDto planteDto);
}