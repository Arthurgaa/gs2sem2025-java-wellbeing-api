package com.example.wellbeing.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleNotFound(NotFoundException ex){
        Map<String,Object> body = new HashMap<>();
        body.put("error","Not Found");
        body.put("message", ex.getMessage());
        body.put("timestamp", LocalDateTime.now().toString());
        body.put("status", 404);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidation(MethodArgumentNotValidException ex){
        Map<String,Object> body = new HashMap<>();
        body.put("error","Bad Request");
        body.put("message", ex.getBindingResult().getFieldErrors().stream().map(e-> e.getField()+": "+e.getDefaultMessage()).collect(Collectors.toList()));
        body.put("timestamp", LocalDateTime.now().toString());
        body.put("status", 400);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGeneric(Exception ex){
        Map<String,Object> body = new HashMap<>();
        body.put("error","Internal Server Error");
        body.put("message", ex.getMessage());
        body.put("timestamp", LocalDateTime.now().toString());
        body.put("status", 500);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
    }
}
