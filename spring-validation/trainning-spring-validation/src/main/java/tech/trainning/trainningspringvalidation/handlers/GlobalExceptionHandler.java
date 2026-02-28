package tech.trainning.trainningspringvalidation.handlers;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import tech.trainning.trainningspringvalidation.errors.AbstractError;
import tech.trainning.trainningspringvalidation.errors.ConstraintViolationError;
import tech.trainning.trainningspringvalidation.exceptions.EnumJsonParserException;

import java.time.Instant;
import java.util.ArrayList;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<AbstractError<?>> handleMethodArgumentNotValidation(
            MethodArgumentNotValidException e, HttpServletRequest request
    ) {
        ConstraintViolationError errors = new ConstraintViolationError(Instant.now(), HttpStatus.BAD_REQUEST.value(),
                "Dados inválidos", new ArrayList<>(), request.getRequestURI());

        for (FieldError f : e.getBindingResult().getFieldErrors()) {
            errors.addError(f.getField(), f.getDefaultMessage());
        }

        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(EnumJsonParserException.class)
    public ResponseEntity<AbstractError<?>> handleEnumJSONParserException(
            EnumJsonParserException e, HttpServletRequest request
    ) {
        ConstraintViolationError errors = new ConstraintViolationError(Instant.now(), HttpStatus.BAD_REQUEST.value(),
                "Dados inválidos", new ArrayList<>(), request.getRequestURI());

        errors.addError(e.getMessage());

        return ResponseEntity.badRequest().body(errors);
    }

}
