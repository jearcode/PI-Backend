package com.luxevision.backend.exception;

public class StudioAlreadyInFavoritesException extends RuntimeException {
    public StudioAlreadyInFavoritesException(String message) {
        super(message);
    }
}