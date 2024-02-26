package main.app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import main.app.dto.UserDto;
import main.app.entities.UserDb;



@Mapper(componentModel = "spring")
public interface UserMapper {

	 UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	 
	  @Mapping(target = "id", ignore = true)
      UserDb toUser(UserDto userdto);

//    User toEntity(UserDto userDto);
}