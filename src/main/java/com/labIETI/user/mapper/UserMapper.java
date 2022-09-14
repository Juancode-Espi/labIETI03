package com.labIETI.user.mapper;

import com.labIETI.user.dto.UserDto;
import com.labIETI.user.entities.User;
import com.labIETI.user.enums.RoleEnum;
import org.mapstruct.*;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "password", target = "passwordHash", qualifiedByName = "passToHash")
    User toEntity(UserDto userDto);

    UserDto toDto(User user);

    @Named("passToHash")
    static String passToHash(String password){
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    @AfterMapping
    default void setDefaultRole(@MappingTarget User user){
        List<RoleEnum> roles = new ArrayList<>();
        roles.add(RoleEnum.USER);
        user.setRoles(roles);
    }



}
