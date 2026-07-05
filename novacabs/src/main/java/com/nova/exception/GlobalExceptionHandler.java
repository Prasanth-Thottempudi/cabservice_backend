package com.nova.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Customer Not Found Exception
     */
    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleCustomerNotFoundException(
            CustomerNotFoundException ex,
            HttpServletRequest request) {

        ErrorResponse response = new ErrorResponse();
        response.setTimestamp(LocalDateTime.now());
        response.setStatus(HttpStatus.NOT_FOUND.value());
        response.setError(HttpStatus.NOT_FOUND.getReasonPhrase());
        response.setMessage(ex.getMessage());
        response.setPath(request.getRequestURI());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }



    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> handleDataIntegrityViolationException(
            DataIntegrityViolationException ex,
            HttpServletRequest request) {

        ErrorResponse response = new ErrorResponse();

        response.setTimestamp(LocalDateTime.now());
        response.setStatus(HttpStatus.CONFLICT.value());
        response.setError(HttpStatus.CONFLICT.getReasonPhrase());

        String message = "Duplicate value already exists.";

        Throwable rootCause = ex.getRootCause();

        if (rootCause != null && rootCause.getMessage() != null) {

            String error = rootCause.getMessage();

            if (error.contains("Key (email)=(")) {

                int start = error.indexOf("Key (email)=(") + "Key (email)=(".length();
                int end = error.indexOf(") already exists");

                if (start > 0 && end > start) {
                    message = error.substring(start, end) + " already exists.";
                }
            }

            else if (error.contains("Key (mobile_number)=(")) {

                int start = error.indexOf("Key (mobile_number)=(")
                        + "Key (mobile_number)=(".length();
                int end = error.indexOf(") already exists");

                if (start > 0 && end > start) {
                    message = error.substring(start, end) + " already exists.";
                }
            }
        }

        response.setMessage(message);
        response.setPath(request.getRequestURI());

        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    /**
     * Validation Exception
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationException(
            MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    /**
     * Generic Exception
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(
            Exception ex,
            HttpServletRequest request) {

        ErrorResponse response = new ErrorResponse();
        response.setTimestamp(LocalDateTime.now());
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.setError(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        response.setMessage(ex.getMessage());
        response.setPath(request.getRequestURI());

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}