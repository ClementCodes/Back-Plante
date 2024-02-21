package com.example.demo.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class UserDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50, nullable = false, unique = true) // Définir la taille maximale du champ à 50 caractères, non nullable et unique
    private String firstName;
    @Column(length = 100, nullable = false) // Définir la taille maximale du champ à 100 caractères et non nullable
    private String lastName;
    
    
    
    @Column(nullable = false)
    private String login; // Ajout du champ "role"
    
    @Column(nullable = false)
    private String role; // Ajout du champ "role"
    
    @Column(nullable = false)
    private String token; // Ajout du champ "role"
   
}