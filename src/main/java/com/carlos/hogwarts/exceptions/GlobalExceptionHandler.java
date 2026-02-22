package com.carlos.hogwarts.exceptions;

import java.util.HashMap;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    // 1. Captura errores de validación (Ej: anyo_curso > 7) -> Retorna 400
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errores = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errores.put(error.getField(), error.getDefaultMessage()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errores);
    }

    // 2. Captura errores de integridad (duplicados, etc.) -> Retorna 409
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleDataIntegrity(DataIntegrityViolationException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body("Error de integridad: El dato viola una restricción de la base de datos.");
    }

    // 3. Captura cuando no se encuentra un Estudiante/Asignatura -> Retorna 404
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleNotFound(EntityNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    // 4. Captura el error de "Tiene alumnos" -> Retorna 409
    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<String> handleIllegalState(IllegalStateException ex) {
        // Devolvemos 409 Conflict porque la operación choca con el estado actual (relaciones existentes)
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }
}
