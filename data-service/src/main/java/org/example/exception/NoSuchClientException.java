package org.example.exception;

public class NoSuchClientException extends RuntimeException{
    public NoSuchClientException(String message) {
        super(message);
    }

    public NoSuchClientException(String message, Throwable cause) {
        super(message, cause);
    }
}
