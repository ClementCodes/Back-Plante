package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Vous pouvez ajouter des méthodes spécifiques de requête ici si nécessaire
	
	Optional<User> findByLogin(String login);
}
