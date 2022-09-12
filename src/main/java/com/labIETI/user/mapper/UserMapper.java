package com.labIETI.user.mapper;

import com.labIETI.user.dto.UserDto;
import com.labIETI.user.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserDto userDto);

    UserDto toDto(User user);
}
