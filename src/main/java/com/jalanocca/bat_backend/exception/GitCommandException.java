package com.jalanocca.bat_backend.exception;

public class GitCommandException extends RuntimeException {
    public GitCommandException(String message) {
        super(message);
    }
}
