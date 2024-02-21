package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UserDto {

	
	
	private Long id;
	private String firstname;
	private String lastName;
	private String login;
	private String role;
	private String token;
}
