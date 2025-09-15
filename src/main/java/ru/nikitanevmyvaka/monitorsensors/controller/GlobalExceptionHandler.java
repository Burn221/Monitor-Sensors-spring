package ru.nikitanevmyvaka.monitorsensors.controller;


import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.nikitanevmyvaka.monitorsensors.exceptions.ConflictException;
import ru.nikitanevmyvaka.monitorsensors.exceptions.MissingArgumentException;
import ru.nikitanevmyvaka.monitorsensors.model.ErrorResponse;
import ru.nikitanevmyvaka.monitorsensors.model.Response;

import java.time.LocalDateTime;


//todo
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MissingArgumentException.class)
    public ResponseEntity<ErrorResponse> handleMissingArgumentException(MissingArgumentException e, HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ErrorResponse(e.getMessage(),request.getRequestURI(), HttpStatus.NOT_FOUND.value(), LocalDateTime.now())
        );
    }


    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<ErrorResponse> handleConflictException(ConflictException e, HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ErrorResponse(e.getMessage(), request.getRequestURI(),HttpStatus.NOT_FOUND.value(),LocalDateTime.now())
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleAnyException(Exception e, HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                new ErrorResponse(e.getMessage(), request.getRequestURI(), HttpStatus.INTERNAL_SERVER_ERROR.value(), LocalDateTime.now())
        );
    }

}
