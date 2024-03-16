package main.app.services;



import main.app.dto.CredentialsDto;
import main.app.dto.SignUpDto;
import main.app.dto.UserDto;

public interface UserService {
//test
	UserDto login(CredentialsDto credentialsDto) ;
	UserDto register(SignUpDto userDto);
	UserDto findByLogin(String login);
	

}
