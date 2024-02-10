package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plantes")
public class PlanteController {

    @Autowired
    private PlanteService planteService;

    @GetMapping
    public List<Plante> getAllPlantes() {
        return planteService.getAllPlantes();
    }

    @GetMapping("/{id}")
    public Optional<Plante> getPlanteById(@PathVariable Long id) {
        return planteService.getPlanteById(id);
    }

    @PostMapping
    public Plante savePlante(@RequestBody Plante plante) {
        return planteService.savePlante(plante);
    }

    
    // test
    @PutMapping("/{id}")
    public Plante updatePlante(@PathVariable Long id, @RequestBody Plante plante) {
        // Assurez-vous que l'ID dans le chemin correspond à l'ID dans le corps de la requête
        plante.setId(id);
        return planteService.savePlante(plante);
    }

    @DeleteMapping("/{id}")
    public void deletePlante(@PathVariable Long id) {
        planteService.deletePlante(id);
    }
}