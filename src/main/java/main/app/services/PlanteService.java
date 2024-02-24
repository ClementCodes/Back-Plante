package main.app.services;

import java.util.List;

import main.app.dto.PlanteDto;
import main.app.entities.Plante;

public interface PlanteService {
	Plante createPlante(PlanteDto planteDto);

	Plante getPlanteById(Long id);

	List<Plante> getAllPlantes();

	Plante updatePlante(Long id, PlanteDto planteDto);

	void deletePlante(Long id);
}