package com.example.spring.dto;

import com.example.spring.additional.validation.ValidEmail;
import com.example.spring.model.Role;
import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserLoginDto {
    @NotEmpty
    @ValidEmail
    private String email;

    @NotEmpty
    private String password;
}
