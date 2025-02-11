package com.twentyone.termgame.common.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  // ✅ จัดการ Validation Error (`@Valid`, `@NotNull`, etc.)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Map<String, Object>> handleValidationExceptions(MethodArgumentNotValidException ex) {
    Map<String, Object> errors = new HashMap<>();
    ex.getBindingResult().getAllErrors().forEach(error -> {
      String fieldName = ((FieldError) error).getField();
      String errorMessage = error.getDefaultMessage();
      errors.put(fieldName, errorMessage);
    });

    Map<String, Object> response = new HashMap<>();
    response.put("result", Boolean.FALSE);
    response.put("status", HttpStatus.BAD_REQUEST.value());
    response.put("error", "Validation Error");
    response.put("errors", errors);

    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
  }

  // ✅ จัดการ Custom Exception (เช่น `throw new CustomException("Invalid input",
  // HttpStatus.BAD_REQUEST)`)
  @ExceptionHandler(CustomException.class)
  public ResponseEntity<Map<String, Object>> handleCustomException(CustomException ex) {
    Map<String, Object> response = new HashMap<>();
    response.put("result", Boolean.FALSE);
    response.put("status", ex.getStatus().value());
    response.put("error", ex.getStatus().getReasonPhrase());
    response.put("message", ex.getMessage());

    return new ResponseEntity<>(response, ex.getStatus());
  }
}
