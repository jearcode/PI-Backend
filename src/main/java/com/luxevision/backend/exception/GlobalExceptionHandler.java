package com.luxevision.backend.exception;

import com.luxevision.backend.dto.ApiError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handlerGenericException(Exception e, HttpServletRequest request) {

        ApiError apiError = new ApiError();
        apiError.setTimestamp(LocalDateTime.now());
        apiError.setError(e.getMessage());
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

}
