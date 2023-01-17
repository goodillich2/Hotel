package com.agacorporation.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such reservation")
public class RoomNotFoundException extends RuntimeException{

    public RoomNotFoundException(){
        super(String.format("Не відповідає"));
    }

    public RoomNotFoundException(Long id){
        super(String.format("Кімната з id% d не існує", id));
    }
}
