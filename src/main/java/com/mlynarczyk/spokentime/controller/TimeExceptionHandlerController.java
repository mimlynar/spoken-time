package com.mlynarczyk.spokentime.controller;

import com.mlynarczyk.spokentime.domain.WrongTimeFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class TimeExceptionHandlerController extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<Object> handleCityNotFoundException(
            WrongTimeFormatException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
