package org.luvom.mockmicroservices.exception;

import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class OpenApiExceptionHandler {

    @ExceptionHandler(OpenApiResourceNotFoundException.class)
    public ResponseEntity<String> handleOpenApiNotFound(OpenApiResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
