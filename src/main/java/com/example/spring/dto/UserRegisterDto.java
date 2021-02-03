package com.example.spring.dto;

import com.example.spring.additional.validation.PasswordMatches;
import com.example.spring.additional.validation.ValidEmail;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@PasswordMatches
public class UserRegisterDto {
    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty
    @ValidEmail
    private String email;

    @NotEmpty
    private String password;

    @NotEmpty
    private String matchingPassword;

    private final LocalDateTime created = LocalDateTime.now();
}
