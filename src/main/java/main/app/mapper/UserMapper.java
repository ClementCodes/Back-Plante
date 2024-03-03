package main.app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import main.app.dto.SignUpDto;
import main.app.dto.UserDto;
import main.app.entities.User;



@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toUserDto(User user);

    @Mapping(target = "password", ignore = true)
    User signUpToUser(SignUpDto signUpDto);

}