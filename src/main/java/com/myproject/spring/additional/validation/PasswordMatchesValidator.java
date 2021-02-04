package com.myproject.spring.additional.validation;

import com.myproject.spring.dto.UserRegisterDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

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

