package com.luxevision.backend.exception;

import com.luxevision.backend.dto.ApiError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handlerGenericException(Exception e, HttpServletRequest request) {

        ApiError apiError = new ApiError();
        apiError.setTimestamp(LocalDateTime.now());
        apiError.setError(e.getLocalizedMessage());
        apiError.setMessage("Internal Server Error");
        apiError.setMethod(request.getMethod());

        return ResponseEntity.status(500).body(apiError);

    }

    @ExceptionHandler(StudioNameAlreadyRegisteredException.class)
    public ResponseEntity<?> handlerStudioNameAlreadyRegisteredException(StudioNameAlreadyRegisteredException e, HttpServletRequest request) {

        ApiError apiError = new ApiError();
        apiError.setTimestamp(LocalDateTime.now());
        apiError.setError(e.getMessage());
        apiError.setMessage("Studio name already registered");
        apiError.setMethod(request.getMethod());

        return ResponseEntity.status(409).body(apiError);

    }

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<?> handlerObjectNotFoundException(ObjectNotFoundException e, HttpServletRequest request) {
        ApiError apiError = new ApiError();
        apiError.setTimestamp(LocalDateTime.now());
        apiError.setError("Object not found");
        apiError.setMessage(e.getMessage());
        apiError.setMethod(request.getMethod());
        return ResponseEntity.status(404).body(apiError);
    }

    @ExceptionHandler(UserEmailAlreadyRegisteredException.class)
    public ResponseEntity<?> handlerUserEmailAlreadyRegisteredException(UserEmailAlreadyRegisteredException e, HttpServletRequest request) {
        ApiError apiError = new ApiError();
        apiError.setTimestamp(LocalDateTime.now());
        apiError.setError(e.getMessage());
        apiError.setMessage("User email already registered");
        apiError.setMethod(request.getMethod());
        return ResponseEntity.status(409).body(apiError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handlerMethodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request) {
        ApiError apiError = new ApiError();
        apiError.setTimestamp(LocalDateTime.now());
        apiError.setError(e.getBindingResult().getFieldError().getDefaultMessage());
        apiError.setMessage("Error in the request sent");
        apiError.setMethod(request.getMethod());
        return ResponseEntity.status(400).body(apiError);

    }

    @ExceptionHandler(NoChangesMadeException.class)
    public ResponseEntity<?> handlerNoChangesMadeException() {
        return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
    }

}
