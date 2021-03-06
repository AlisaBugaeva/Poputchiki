package com.poputchiki.errors;

import com.poputchiki.dto.error.ErrorMessage;
import com.poputchiki.services.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class MyExceptionHandler {
    private Logger log = LoggerFactory.getLogger(MyExceptionHandler.class);

    @ExceptionHandler(PoputchikiAppException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage handle(PoputchikiAppException ex){
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setErrorMessage(ex.getMessage());
        return errorMessage;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage handle(MethodArgumentNotValidException ex){

        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setErrorMessage(ex.getFieldError().getDefaultMessage());
        log.info(errorMessage.toString());
        return errorMessage;
    }


    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage handleValidationException(ConstraintViolationException ex) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setErrorMessage(ex.getMessage());
        return errorMessage;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage handleAllException(Exception ex) {
        log.warn(ex.getMessage());
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setErrorMessage(ex.getMessage());
        return errorMessage;
    }
}
