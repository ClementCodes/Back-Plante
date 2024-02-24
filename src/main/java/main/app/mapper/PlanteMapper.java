package main.app.mapper;

import org.mapstruct.Mapper;

import main.app.dto.PlanteDto;
import main.app.entities.Plante;


@Mapper(componentModel = "spring")
public interface PlanteMapper {

	
	  PlanteDto toPlanteDto(Plante plante);
}
