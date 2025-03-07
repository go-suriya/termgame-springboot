package com.twentyone.termgame.common.exception;

import com.twentyone.termgame.common.dto.response.ResponseDto;
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

    // Validation Error (`@Valid`, `@NotNull`, etc.)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDto<Map<String, String>>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        ResponseDto<Map<String, String>> response = ResponseDto.<Map<String, String>>builder()
                .result(Boolean.FALSE)
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .message("Validation Error")
                .error(errors)
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    // Custom Exception (เช่น `throw new CustomException("Invalid input",
    // HttpStatus.BAD_REQUEST)`)
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ResponseDto<Object>> handleCustomException(CustomException ex) {
        ResponseDto<Object> response = ResponseDto.builder()
                .result(Boolean.FALSE)
                .statusCode(ex.getStatus().value())
                .message(ex.getMessage())
                .error(ex.getStatus().getReasonPhrase())
                .build();

        return ResponseEntity.status(ex.getStatus()).body(response);
    }
}
