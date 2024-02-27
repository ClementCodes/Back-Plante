package main.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

	private Long id;

	private String firstName;

	private String UserName;

	private String login; // Ajout du champ "role"

	private String role; // Ajout du champ "role"

	private String token; // Ajout du champ "role"

}