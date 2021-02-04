package com.myproject.spring.dto;

import com.myproject.spring.dto.mapper.UserMapper;
import com.myproject.spring.model.User;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserDtoMapperTest {
    private final UserMapper mapper = Mappers.getMapper(UserMapper.class);

    @Test
    public void userLoginDTOtoUser_whenMaps_thenCorrect() {
        UserLoginDto loginDto = new UserLoginDto();
        loginDto.setEmail("user@email.com");
        loginDto.setPassword("somePassword");

        User user = mapper.userLoginDtoToUser(loginDto);

        assertEquals(loginDto.getEmail(), user.getEmail());
        assertEquals(loginDto.getPassword(), user.getPassword());
    }

    @Test
    public void userToUserLoginDTO_whenMaps_thenCorrect() {
        User user = new User();
        user.setEmail("user@email.com");
        user.setPassword("somePassword");

        UserLoginDto loginDto = mapper.userToUserLoginDto(user);

        assertEquals(user.getEmail(), loginDto.getEmail());
        assertEquals(user.getPassword(), loginDto.getPassword());
    }

    @Test
    public void userRegisterDtoToUser_whenMaps_thenCorrect() {
        UserRegisterDto registerDto = new UserRegisterDto();
        registerDto.setFirstName("userFirstName");
        registerDto.setLastName("userLastName");
        registerDto.setEmail("user@someemail.coom");
        registerDto.setPassword("userSomePassword");
        registerDto.setMatchingPassword("userSomePassword");

        User user = mapper.userRegisterDtoToUser(registerDto);

        assertEquals(registerDto.getEmail(), user.getEmail());
    }
}
