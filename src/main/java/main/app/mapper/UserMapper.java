package main.app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import main.app.dto.SignUpDto;
import main.app.dto.UserDto;
import main.app.entities.UserDb;



@Mapper(componentModel = "spring")
public interface UserMapper {

	   UserDto toUserDto(UserDb user);

	    @Mapping(target = "password", ignore = true)
	    UserDb signUpToUser(SignUpDto signUpDto);
}