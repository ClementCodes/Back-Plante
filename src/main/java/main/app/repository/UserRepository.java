package main.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.app.entities.UserDb;


public interface UserRepository extends JpaRepository<UserDb, Long> {
    // Vous pouvez ajouter des méthodes spécifiques de requête ici si nécessaire
	
	Optional<UserDb> findByLogin(String login);

//	UserDb findByUserName(String username);
	
}
