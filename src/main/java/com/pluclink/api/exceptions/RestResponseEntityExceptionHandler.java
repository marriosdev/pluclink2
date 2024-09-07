package com.pluclink.api.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class RestResponseEntityExceptionHandler{

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Map<String, String>> handleNotFound(NotFoundException ex, WebRequest webRequest) {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Item não encontrado");
        response.put("code",  "404");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
