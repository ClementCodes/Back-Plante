package com.example.demo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthUserRepository extends JpaRepository<AuthUser, Long> {
    // Ajoutez des méthodes de requête personnalisées si nécessaire
	 Optional<AuthUser> findByMail(String email);
}
