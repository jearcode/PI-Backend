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

    @ExceptionHandler(MinimumImagesRequirementException.class)
    public ResponseEntity<?> handlerMinimumImagesRequirementException(MinimumImagesRequirementException e, HttpServletRequest request) {
        ApiError apiError = new ApiError();
        apiError.setTimestamp(LocalDateTime.now());
        apiError.setError("Minimum images requirement");
        apiError.setMessage(e.getMessage());
        apiError.setMethod(request.getMethod());
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(apiError);
    }

    @ExceptionHandler(StudioAlreadyInFavoritesException.class)
    public ResponseEntity<?> handleStudioAlreadyInFavoritesException(StudioAlreadyInFavoritesException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }
    @ExceptionHandler(StudioNotInFavoritesException.class)
    public ResponseEntity<?> handleStudioNotInFavoritesException(StudioNotInFavoritesException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(StudioSpecialtyNotFoundException.class)
    public ResponseEntity<?> handleStudioSpecialtyNotFoundException(StudioSpecialtyNotFoundException e, HttpServletRequest request) {
        ApiError apiError = new ApiError();
        apiError.setTimestamp(LocalDateTime.now());
        apiError.setError("Studio with unrelated specialty");
        apiError.setMessage(e.getMessage());
        apiError.setMethod(request.getMethod());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
    }

    @ExceptionHandler(InvalidScheduleException.class)
    public ResponseEntity<?> handleInvalidScheduleException(InvalidScheduleException e, HttpServletRequest request) {
        ApiError apiError = new ApiError();
        apiError.setTimestamp(LocalDateTime.now());
        apiError.setError("Invalid schedule");
        apiError.setMessage(e.getMessage());
        apiError.setMethod(request.getMethod());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
    }

    @ExceptionHandler(StudioHoursViolationException.class)
    public ResponseEntity<?> handleStudioHoursViolationException(StudioHoursViolationException e, HttpServletRequest request) {
        ApiError apiError = new ApiError();
        apiError.setTimestamp(LocalDateTime.now());
        apiError.setError("Studio Hours Conflict");
        apiError.setMessage(e.getMessage());
        apiError.setMethod(request.getMethod());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiError);
    }

    @ExceptionHandler(BookingConflictException.class)
    public ResponseEntity<?> handleBookingConflictException(BookingConflictException e, HttpServletRequest request) {
        ApiError apiError = new ApiError();
        apiError.setTimestamp(LocalDateTime.now());
        apiError.setError("Booking conflict");
        apiError.setMessage(e.getMessage());
        apiError.setMethod(request.getMethod());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiError);
    }

    @ExceptionHandler(InvalidPriceException.class)
    public ResponseEntity<?> handleInvalidPriceException(InvalidPriceException e, HttpServletRequest request) {
        ApiError apiError = new ApiError();
        apiError.setTimestamp(LocalDateTime.now());
        apiError.setError("Invalid price");
        apiError.setMessage(e.getMessage());
        apiError.setMethod(request.getMethod());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
    }

    @ExceptionHandler(InvalidUserException.class)
    public ResponseEntity<?> handleInvalidUserException(InvalidUserException e, HttpServletRequest request) {
        ApiError apiError = new ApiError();
        apiError.setTimestamp(LocalDateTime.now());
        apiError.setError("Invalid user");
        apiError.setMessage(e.getMessage());
        apiError.setMethod(request.getMethod());
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(apiError);
    }

}
