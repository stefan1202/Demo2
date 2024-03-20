package ro.sda.java64.demo2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ro.sda.java64.demo2.exceptions.SdaException;

@RestControllerAdvice
public class ControllerAdviceHandler {
    @ExceptionHandler(value = SdaException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> handleArithmeticException(SdaException ex){
        return ResponseEntity.status(579).body(ex.getMessage() + " | " + ex.getErrorsList());
    }
}
