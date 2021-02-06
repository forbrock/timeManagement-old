package com.myproject.spring.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
@RequestMapping("/index")
@PreAuthorize("hasAuthority('read')")
public class UserController {

    @GetMapping
    @ResponseBody
    public String currentUserName(Principal principal) {
        return principal.getName();
    }
}
