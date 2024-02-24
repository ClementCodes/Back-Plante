package main.app.services;
import java.util.List;
import java.util.Optional;

import main.app.entities.Plante;



public interface PlanteService {
    List<Plante> getAllPlantes();
    Optional getPlanteById(Long id);
    Plante savePlante(Plante plante);
    void deletePlante(Long id);
}



