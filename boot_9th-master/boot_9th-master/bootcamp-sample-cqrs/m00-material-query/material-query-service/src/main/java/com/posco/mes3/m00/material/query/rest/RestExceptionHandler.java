package com.posco.mes3.m00.material.query.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@ControllerAdvice
@RestController
public class RestExceptionHandler {
    //
    @ResponseStatus(HttpStatus.NOT_FOUND) // 404
    @ExceptionHandler(NoSuchElementException.class)
    public void handleNotFound() {}
}
