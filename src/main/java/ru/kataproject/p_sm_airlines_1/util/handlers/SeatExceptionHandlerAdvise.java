package ru.kataproject.p_sm_airlines_1.util.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.kataproject.p_sm_airlines_1.entity.Dto.ErrorResponseDto;
import ru.kataproject.p_sm_airlines_1.util.exceptions.SeatNotFoundException;

@ControllerAdvice(annotations = SeatExceptionHandler.class)
public class SeatExceptionHandlerAdvise extends AbstractExceptionHandler{

    @ExceptionHandler(SeatNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> resourceNotFoundExceptionHandler(final SeatNotFoundException e) {
        return buildErrorResponse(e, HttpStatus.NOT_FOUND);
    }
}
