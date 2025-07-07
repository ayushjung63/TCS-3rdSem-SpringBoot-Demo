package com.tcs.demo.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public Map<String,Object> handleRuntimeException(RuntimeException ex){
        String message = ex.getMessage();
        return Map.of(
                "message",message,
                "success",false
        );
   }
}
