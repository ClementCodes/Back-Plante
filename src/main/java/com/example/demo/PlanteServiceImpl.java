package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Service
//public class PlanteServiceImpl implements PlanteService {
//
//    @Autowired
//    private PlanteRepository planteRepository;
//
//    @Override
//    public List<Plante> getAllPlantes() {
//        return planteRepository.findAll();
//    }
//
//    @Override
//    public Optional getPlanteById(Long id) {
//        return planteRepository.findById(id);
//    }
//
//    @Override
//    public Plante savePlante(Plante plante) {
//        return planteRepository.save(plante);
//    }
//
//    @Override
//    public void deletePlante(Long id) {
//        planteRepository.deleteById(id);
//    }
//}