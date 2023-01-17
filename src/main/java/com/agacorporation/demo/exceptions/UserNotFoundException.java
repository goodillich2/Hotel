package com.agacorporation.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such user")
public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(){
        super(String.format("User не існує"));
    }

    public UserNotFoundException(Long id){
        super(String.format("User з id% d не існує", id));
    }
}
