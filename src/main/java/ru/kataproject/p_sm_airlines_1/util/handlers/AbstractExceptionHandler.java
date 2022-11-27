package ru.kataproject.p_sm_airlines_1.util.handlers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.kataproject.p_sm_airlines_1.entity.Dto.ErrorResponseDto;

public abstract class AbstractExceptionHandler {
    private static final Logger log = LogManager.getLogger(AbstractExceptionHandler.class);

    protected ResponseEntity<ErrorResponseDto> buildErrorResponse(final Throwable throwable,
                                                                  final HttpStatus httpStatus) {
        log.error(throwable.getMessage(), throwable);
        return new ResponseEntity<>(buildErrorResponseDTO(throwable.getMessage()), httpStatus);
    }

    protected ResponseEntity<ErrorResponseDto> buildErrorResponse(final Throwable throwable, final String message,
                                                                  final HttpStatus httpStatus) {
        log.error(throwable.getMessage(), throwable);
        return new ResponseEntity<>(buildErrorResponseDTO(message), httpStatus);
    }

    private ErrorResponseDto buildErrorResponseDTO(final String message) {
        return new ErrorResponseDto(message);
    }
}
