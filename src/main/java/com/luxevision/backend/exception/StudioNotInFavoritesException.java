package com.luxevision.backend.exception;

public class StudioNotInFavoritesException extends RuntimeException {
    public StudioNotInFavoritesException(String message) {
        super(message);
    }
}