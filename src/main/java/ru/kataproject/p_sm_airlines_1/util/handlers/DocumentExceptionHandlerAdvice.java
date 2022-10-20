package ru.kataproject.p_sm_airlines_1.util.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.kataproject.p_sm_airlines_1.entity.Dto.ErrorResponseDto;
import ru.kataproject.p_sm_airlines_1.util.exceptions.DocumentNotFoundException;

@ControllerAdvice(annotations = DocumentExceptionHandler.class)
public class DocumentExceptionHandlerAdvice extends AbstractExceptionHandler {
    @ExceptionHandler(DocumentNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> resourceNotFoundExceptionHandler(final DocumentNotFoundException e) {
        return buildErrorResponse(e, HttpStatus.NOT_FOUND);
    }
}
