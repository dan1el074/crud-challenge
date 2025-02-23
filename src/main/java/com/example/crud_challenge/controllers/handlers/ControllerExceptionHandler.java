package com.example.crud_challenge.controllers.handlers;

import com.example.crud_challenge.dtos.errors.CustomError;
import com.example.crud_challenge.dtos.errors.FieldMessage;
import com.example.crud_challenge.dtos.errors.ValidationError;
import com.example.crud_challenge.service.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        CustomError customError = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getServletPath());
        return ResponseEntity.status(status.value()).body(customError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomError> methodArgumentNotValid(MethodArgumentNotValidException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        ValidationError customError = new ValidationError(Instant.now(), status.value(), "Dados inválidos", request.getServletPath());
        for(FieldError f : e.getBindingResult().getFieldErrors()) {
            customError.addErrors(new FieldMessage(f.getField(), f.getDefaultMessage()));
        }
        return ResponseEntity.status(status.value()).body(customError);
    }
}
