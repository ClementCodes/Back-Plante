package main.app.services;

import java.util.List;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import main.app.dto.UserDto;
import main.app.entities.UserDb;

public interface UserService {

	UserDb createUser(UserDto userDto);

	UserDb getUserById(Long id);

	List<UserDb> getAllUsers();

	UserDb updateUser(Long id, UserDto userDto);

	void deleteUser(Long id);

	UserDb findbyUserName(String username) throws UsernameNotFoundException;

	UserDb loadUserByUsername(String username) throws UsernameNotFoundException;
}
