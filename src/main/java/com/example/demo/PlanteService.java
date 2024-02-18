package com.example.demo;
import java.util.List;
import java.util.Optional;



public interface PlanteService {
    List<Plante> getAllPlantes();
    Optional getPlanteById(Long id);
    Plante savePlante(Plante plante);
    void deletePlante(Long id);
}