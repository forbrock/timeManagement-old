package com.example.spring.dto.mapper;

import com.example.spring.dto.UserLoginDto;
import com.example.spring.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User userLoginDtoToUser(UserLoginDto userLoginDto);
    UserLoginDto userToUserLoginDto(User user);
}
