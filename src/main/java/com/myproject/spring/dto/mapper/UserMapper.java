package com.myproject.spring.dto.mapper;

import com.myproject.spring.dto.UserLoginDto;
import com.myproject.spring.dto.UserRegisterDto;
import com.myproject.spring.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User userLoginDtoToUser(UserLoginDto userLoginDto);

    @Mapping(target = "role", constant = "USER")
    @Mapping(target = "state", constant = "ACTIVE")
    User userRegisterDtoToUser(UserRegisterDto userRegisterDto);

    UserLoginDto userToUserLoginDto(User user);
}
