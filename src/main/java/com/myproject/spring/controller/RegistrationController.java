package com.myproject.spring.controller;

import com.myproject.spring.dto.UserRegisterDto;
import com.myproject.spring.exceptions.UserAlreadyExistException;
import com.myproject.spring.model.User;
import com.myproject.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/auth")
public class RegistrationController {
    private UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String showRegistrationPage(@ModelAttribute("user") UserRegisterDto user) {
        return "registration";
    }

    @PostMapping("/registration")
    public String registerUserAccount(@ModelAttribute("user") @Valid UserRegisterDto registerDto,
                                      BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "registration";
        }

        try {
            // TODO: check password encoding
            User registered = userService.registerNewAccount(registerDto);
        } catch (UserAlreadyExistException e) {
            // TODO: add logger
            bindingResult.rejectValue("email", "user.email",
                    "An account for this username/email already exists.");
            return "registration";
        }
        return "redirect:/login";
    }
}
