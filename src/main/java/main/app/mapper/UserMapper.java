package main.app.mapper;

import org.mapstruct.Mapper;

import main.app.dto.UserDto;
import main.app.entities.User;



@Mapper(componentModel = "spring")
public interface UserMapper {

	
    UserDto toUserDto(User user);

//    User toEntity(UserDto userDto);
}