package com.poputchiki.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class PoputchikiAppException extends RuntimeException {
    public PoputchikiAppException(String message) {
        super(message);
    }
}