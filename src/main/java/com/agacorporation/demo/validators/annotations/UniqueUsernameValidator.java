package com.agacorporation.demo.validators.annotations;


import com.agacorporation.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

    @Autowired(required = false)
    private UserService userService;

    public void initialize(UniqueUsername constraint) {
    }

    public boolean isValid(String login, ConstraintValidatorContext context) {
        //під час запуску RepositoryInitializer служба userService ще не була введена в цей валідатор, тому userService == null.
        return userService == null || (login != null && userService.isUniqueLogin(login));
    }

}