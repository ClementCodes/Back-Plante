package com.example.demo.maper;

import org.mapstruct.Mapper;

import com.example.demo.dto.UserDto;
import com.example.demo.entities.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

	
    UserDto toUserDto(User user);

//    User toEntity(UserDto userDto);
}