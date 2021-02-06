package com.myproject.spring.validation;

import com.myproject.spring.controller.RegistrationController;
import com.myproject.spring.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ValidationTest {
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
/*
        this.mockMvc = MockMvcBuilders
                .standaloneSetup(new RegistrationController()).build();
*/
    }

    @Test
    public void givenMatchingPassword_whenPostNewUserForm_thenOk() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/auth/registration")
                .accept(MediaType.TEXT_HTML)
                .param("firstName", "firstName")
                .param("lastName", "lastName")
                .param("email", "some@email.com")
                .param("password", "pass")
                .param("matchingPassword", "pass"))
                .andExpect(model().errorCount(0))
                .andExpect(status().isOk());
    }

    @Test
    public void givenNotMatchingPassword_whenPostNewUserForm_thenOk() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("registration")
                .accept(MediaType.TEXT_HTML)
                .param("firstName", "firstName")
                .param("lastName", "lastName")
                .param("email", "some@email.com")
                .param("password", "pass")
                .param("matchingPassword", "passss"))
                .andExpect(model().errorCount(1))
                .andExpect(status().isOk());
    }
}
