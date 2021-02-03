package com.example.spring.service;

import com.example.spring.dto.UserLoginDto;
import com.example.spring.dto.mapper.UserMapper;
import com.example.spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserMapper mapper;

    @Autowired
    public UserService(UserMapper mapper) {
        this.mapper = mapper;
    }

    public UserLoginDto convertUserToUserLoginDto(User user) {
        return mapper.userToUserLoginDto(user);
    }

    public User convertUserLoginDtoToUser(UserLoginDto loginDto) {
        return mapper.userLoginDtoToUser(loginDto);
    }
}
