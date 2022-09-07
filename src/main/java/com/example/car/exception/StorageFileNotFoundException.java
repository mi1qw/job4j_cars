package com.example.car.exception;

public class StorageFileNotFoundException extends StorageException {
    public StorageFileNotFoundException(final String message) {
        super(message);
    }

    public StorageFileNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
