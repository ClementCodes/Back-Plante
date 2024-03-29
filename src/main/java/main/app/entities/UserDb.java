package main.app.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import main.app.enums.Role;

@Data
@Entity
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Table(name = "app_user")
public class UserDb {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "firstName", nullable = false)
	private String firstname;

	@Column(name = "UserName", nullable = false)
	private String userName;

	@Column(name = "login", nullable = false)
	private String login;

	
	@Enumerated(EnumType.STRING)
	@Column(name = "role", nullable = false)
	private   Role role;

	@Column(name = "password", nullable = false)
	private String password;
}
