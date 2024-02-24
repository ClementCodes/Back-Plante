package main.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.app.dto.PlanteDto;
import main.app.entities.Plante;
import main.app.mapper.PlanteMapper;
import main.app.repository.PlanteRepository;

@Service
public class PlanteServiceImpl implements PlanteService {
    


	    @Autowired
	    private PlanteRepository planteRepository;

	    @Override
	    public Plante createPlante(PlanteDto planteDto) {
	        Plante plante = PlanteMapper.INSTANCE.toPlante(planteDto);
	        return planteRepository.save(plante);
	    }

	    @Override
	    public Plante getPlanteById(Long id) {
	        return planteRepository.findById(id).orElse(null);
	    }

	    @Override
	    public List<Plante> getAllPlantes() {
	        return planteRepository.findAll();
	    }

	    @Override
	    public Plante updatePlante(Long id, PlanteDto planteDto) {
	        Plante existingPlante = planteRepository.findById(id).orElse(null);
	        if (existingPlante == null) {
	            return null; // Gérer le cas où la plante n'existe pas
	        }
	        // Mettre à jour les champs de la plante existante avec les données du DTO
	        existingPlante.setNom(planteDto.getNom());
	        existingPlante.setAge(planteDto.getAge());
	        existingPlante.setDateArrosage(planteDto.getDateArrosage());
	        return planteRepository.save(existingPlante);
	    }

	    @Override
	    public void deletePlante(Long id) {
	        planteRepository.deleteById(id);
	    }
	}