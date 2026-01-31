package com.jalanocca.bat_backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.jalanocca.bat_backend.model.dto.GenericResponseDto;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(GitCommandException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<GenericResponseDto> handleGitCommandException(GitCommandException ex) {
        // El mensaje personalizado debe ser pasado en el throw
        GenericResponseDto response = GenericResponseDto.error(ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        // Puedes personalizar el mensaje o devolver un objeto DTO si lo prefieres
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error: " + ex.getMessage());
    }

    // Puedes agregar más métodos para manejar excepciones específicas
}
