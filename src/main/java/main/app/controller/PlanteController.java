package main.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.app.dto.PlanteDto;
import main.app.entities.Plante;
import main.app.services.PlanteService;

@RestController
@RequestMapping("/plantes")
public class PlanteController {
    
	 @Autowired
	    private PlanteService planteService;

	    @PostMapping
	    public ResponseEntity<Plante> createPlante(@RequestBody PlanteDto planteDto) {
	        Plante createdPlante = planteService.createPlante(planteDto);
	        return new ResponseEntity<>(createdPlante, HttpStatus.CREATED);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Plante> getPlanteById(@PathVariable Long id) {
	        Plante plante = planteService.getPlanteById(id);
	        return ResponseEntity.ok(plante);
	    }

	    @GetMapping
	    public ResponseEntity<List<Plante>> getAllPlantes() {
	        List<Plante> plantes = planteService.getAllPlantes();
	        return ResponseEntity.ok(plantes);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Plante> updatePlante(@PathVariable Long id, @RequestBody PlanteDto planteDto) {
	        Plante updatedPlante = planteService.updatePlante(id, planteDto);
	        return ResponseEntity.ok(updatedPlante);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deletePlante(@PathVariable Long id) {
	        planteService.deletePlante(id);
	        return ResponseEntity.noContent().build();
	    }
	}