package ru.nikitanevmyvaka.monitorsensors.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.nikitanevmyvaka.monitorsensors.exceptions.ConflictException;
import ru.nikitanevmyvaka.monitorsensors.exceptions.MissingArgumentException;
import ru.nikitanevmyvaka.monitorsensors.model.Response;


//todo
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MissingArgumentException.class)
    public ResponseEntity<Response> handleMissingArgumentException(MissingArgumentException e){
        Response response= new Response(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<Response> handleConflictException(ConflictException e){
        Response response= new Response(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

}
