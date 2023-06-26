package ch.bbw.m183.vulnerapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> handleGenericException() {
        return new ResponseEntity<>("Ein Fehler ist aufgetaucht, probiere es später nochmals", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}