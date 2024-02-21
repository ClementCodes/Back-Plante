package com.example.demo.entities;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
@Builder
@Table(name = "app_user")
public class User {
	
	@Id
	private Long id;
	
	@Column(name = "first_name" ,nullable = false)
	private String firstname;
	
	@Column(name = "last_name" ,nullable = false)
	private String lastName;
	
	@Column(name = "login" ,nullable = false)
	private String login;
	
	@Column(name = "role" ,nullable = false)
	private String role;
	
	@Column(name = "password" ,nullable = false)
	private String password;
}


