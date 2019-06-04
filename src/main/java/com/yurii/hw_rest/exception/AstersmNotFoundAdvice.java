package com.yurii.hw_rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AstersmNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(ArrayStoreException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String asterismNotFoundHandler(AstersmNotFoundException  ex){
        return ex.getMessage();
    }
}
