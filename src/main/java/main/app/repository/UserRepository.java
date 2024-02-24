package main.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import main.app.entities.User;


public interface UserRepository extends JpaRepository<User, Long> {
    // Vous pouvez ajouter des méthodes spécifiques de requête ici si nécessaire
	
	Optional<User> findByLogin(String login);
}
