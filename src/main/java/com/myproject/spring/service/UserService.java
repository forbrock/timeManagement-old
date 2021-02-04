package com.myproject.spring.service;

import com.myproject.spring.dto.UserLoginDto;
import com.myproject.spring.dto.UserRegisterDto;
import com.myproject.spring.dto.mapper.UserMapper;
import com.myproject.spring.exceptions.UserAlreadyExistException;
import com.myproject.spring.model.User;
import com.myproject.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService {
    private UserMapper mapper;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserMapper mapper, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.mapper = mapper;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserLoginDto convertUserToUserLoginDto(User user) {
        return mapper.userToUserLoginDto(user);
    }

    public User convertUserLoginDtoToUser(UserLoginDto loginDto) {
        return mapper.userLoginDtoToUser(loginDto);
    }

    public User convertUserRegisterDtoToUser(UserRegisterDto registerDto) {
        return mapper.userRegisterDtoToUser(registerDto);
    }

    @Transactional
    public User registerNewAccount(UserRegisterDto registerDto)
            throws UserAlreadyExistException {

        User user = convertUserRegisterDtoToUser(registerDto);

        if (emailExist(user.getEmail())) {
            throw new UserAlreadyExistException(
                    "There is an account with this email address: "
                    + user.getEmail());
        }
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        return userRepository.save(user);
    }

    private boolean emailExist(String email) {
        return userRepository.findByEmail(email).orElse(null) != null;
    }
}
