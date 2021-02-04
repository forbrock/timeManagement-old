package com.myproject.spring.security;

import com.myproject.spring.model.Role;
import com.myproject.spring.model.State;
import com.myproject.spring.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserToUserDetailsTest {

    @Test
    public void userToUserDetails_whenMaps_thenCorrect() {
        User user = User.builder()
                .email("some@email.com")
                .password("weakPassword")
                .state(State.ACTIVE)
                .role(Role.USER)
                .build();
        UserDetails userDetails = SecurityUser.convertUserToUserDetails(user);

        assertEquals(user.getPassword(), userDetails.getPassword());
    }
}
