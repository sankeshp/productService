package com.service.productservice.controller;

import com.service.productservice.Model.Product;
import jdk.jshell.Snippet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handleProductNotExistsException(){
        return new ResponseEntity<>("Not found", HttpStatus.FOUND);
    }

}
