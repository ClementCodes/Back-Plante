package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanteService {

    @Autowired
    private PlanteRepository planteRepository;

    public List<Plante> getAllPlantes() {
        return planteRepository.findAll();
    }

    public Optional<Plante> getPlanteById(Long id) {
        return planteRepository.findById(id);
    }

    public Plante savePlante(Plante plante) {
        return planteRepository.save(plante);
    }

    public void deletePlante(Long id) {
        planteRepository.deleteById(id);
    }
}