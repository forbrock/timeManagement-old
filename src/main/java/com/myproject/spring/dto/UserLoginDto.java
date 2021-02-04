package com.myproject.spring.dto;

import com.myproject.spring.additional.validation.ValidEmail;
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
