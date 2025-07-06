package com.ejemplo.gestionventas.exception;


import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

//Se usa Advice para manejar excepciones en un solo lugar. Asi
//controlo errors de validacion y otras excpciones lanzadas y devuelvo
//respuestas JSON claras
@RestControllerAdvice
public class GlobalExceptionHandler {

    // Maneja errores de validación @Valid
    //marcael metodo que maneja un tipo especifico de excepcion
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleValidationErrors(MethodArgumentNotValidException ex) {
        List<String> messages = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.toList());

        ApiError apiError = new ApiError(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                "Error de validación",
                messages
        );
        return ResponseEntity.badRequest().body(apiError);
    }

    // Maneja errores personalizados que puedes lanzar tú
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiError> handleCustomException(RuntimeException ex) {
        ApiError apiError = new ApiError(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                "Error de aplicación",
                List.of(ex.getMessage())
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
    }
}
