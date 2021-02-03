package com.example.spring.additional.validation;

import com.example.spring.dto.UserRegisterDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

public class PasswordMatchesValidator
        implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context){
        if (obj == null) {
            return false;
        }
        UserRegisterDto user = (UserRegisterDto) obj;
        return user.getPassword().equals(user.getMatchingPassword());
    }
}

