package main.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.app.entities.Plante;

public interface PlanteRepository extends JpaRepository<Plante, Long> {
    // Ajoutez des méthodes personnalisées si nécessaire
}