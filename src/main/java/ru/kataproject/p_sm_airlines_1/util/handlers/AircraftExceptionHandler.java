package ru.kataproject.p_sm_airlines_1.util.handlers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.kataproject.p_sm_airlines_1.util.exceptions.AircraftApiFailure;
import ru.kataproject.p_sm_airlines_1.util.exceptions.AircraftNotFoundException;

import java.time.LocalDateTime;

@ControllerAdvice
public class AircraftExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AircraftNotFoundException.class)
    public ResponseEntity<Object> handleAircraftNotFound(AircraftNotFoundException ex, WebRequest request) {

        return new ResponseEntity<Object>(new AircraftApiFailure(ex.getMessage(), HttpStatus.NOT_FOUND
                , LocalDateTime.now()), HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers
            , HttpStatus status, WebRequest request) {
        return new ResponseEntity<Object>(new AircraftApiFailure(ex.getMessage(), HttpStatus.NOT_FOUND
                , LocalDateTime.now()), HttpStatus.NOT_FOUND);
    }
}
