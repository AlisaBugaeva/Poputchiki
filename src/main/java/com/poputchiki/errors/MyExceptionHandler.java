package com.poputchiki.errors;

import com.poputchiki.dto.error.ErrorMessage;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class MyExceptionHandler {

    @ExceptionHandler(PoputchikiAppException.class)
    public ErrorMessage handle(PoputchikiAppException ex){
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setErrorMessage(ex.getMessage());
        return errorMessage;
    }
}
