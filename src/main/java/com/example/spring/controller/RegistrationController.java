package com.example.spring.controller;

import com.example.spring.dto.UserRegisterDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.validation.Valid;

//@Controller
public class RegistrationController {

//    @GetMapping("/user/registration")
    public String showRegistrationForm(@ModelAttribute("account") @Valid UserRegisterDto userRegisterDto) {
        return "registration";
    }
}
