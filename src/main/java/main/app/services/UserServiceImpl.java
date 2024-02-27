package main.app.services;

import java.nio.CharBuffer;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import main.app.dto.CredentialsDto;
import main.app.dto.SignUpDto;
import main.app.dto.UserDto;
import main.app.entities.UserDb;
import main.app.enums.Role;
import main.app.exception.AppException;
import main.app.mapper.UserMapper;
import main.app.repository.UserRepository;


@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

	
	private UserRepository userRepository;

	public final PasswordEncoder passwordEncoder;

	private final UserMapper userMapper;

	@Override
	public UserDto login(CredentialsDto credentialsDto) {
		UserDb user = userRepository.findByLogin(credentialsDto.getLogin())
				.orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));

		if (passwordEncoder.matches(CharBuffer.wrap(credentialsDto.getPassword()), user.getPassword())) {
			return userMapper.toUserDto(user);
		}
		throw new AppException("Invalid password", HttpStatus.BAD_REQUEST);
	}

	@Override
	public UserDto register(SignUpDto userDto) {
		Optional<UserDb> optionalUser = userRepository.findByLogin(userDto.getLogin());

		if (optionalUser.isPresent()) {
			throw new AppException("Login already exists", HttpStatus.BAD_REQUEST);
		}

		UserDb user = userMapper.signUpToUser(userDto);
		user.setRole(Role.USER);
		user.setPassword(passwordEncoder.encode(CharBuffer.wrap(userDto.getPassword())));

		UserDb savedUser = userRepository.save(user);

		return userMapper.toUserDto(savedUser);
	}

	@Override
	public UserDto findByLogin(String login) {
		UserDb user = userRepository.findByLogin(login)
				.orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));
		return userMapper.toUserDto(user);
	}

}
