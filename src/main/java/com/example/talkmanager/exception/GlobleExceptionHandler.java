package com.example.talkmanager.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.cglib.core.Local;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobleExceptionHandler {
    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleTaskNotFound(TaskNotFoundException ex, HttpServletRequest req){
        ErrorResponse errorResponse=new ErrorResponse(
                LocalDateTime.now(),
                404,
                "NOT_FOUND",
                ex.getMessage(),
                req.getRequestURL()
        );
        return ResponseEntity.status(404).body(errorResponse);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationError(MethodArgumentNotValidException ex,HttpServletRequest
                                                               req){
        String message=ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(err->err.getField()+" : "+err.getDefaultMessage())
                .findFirst()
                .orElse("Validation Error");
        ErrorResponse errorResponse=new ErrorResponse(
                LocalDateTime.now(),
                422,
                "VALIDATION_ERROR",
                message,
                req.getRequestURL()
        );
        return ResponseEntity.status(422).body(errorResponse);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleError(Exception ex,HttpServletRequest req){
        ErrorResponse response=new ErrorResponse(
                LocalDateTime.now(),
                500,
                "INTERNAL_SERVER_ERROR",
                ex.getMessage(),
                req.getRequestURL()
        );
        return ResponseEntity.status(500).body(response);
    }
}
