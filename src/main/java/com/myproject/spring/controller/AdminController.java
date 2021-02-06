package com.myproject.spring.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('write')")
public class AdminController {

    @GetMapping
    public String showAdminPage() {
        return "admin";
    }

    @GetMapping("/admin")
    @ResponseBody
    public String currentUserName(Principal principal) {
        return principal.getName();
    }
}
