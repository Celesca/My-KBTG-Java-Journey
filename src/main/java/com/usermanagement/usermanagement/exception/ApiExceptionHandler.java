package com.usermanagement.usermanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.ZonedDateTime;

// Helps Controller to catch response/exceptions that happens
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {NotFoundException.class})
    // Exception ถ้าเป็นคลาสนี้เเราจะใช้ Function แล้วรับเข้ามา แล้ว Build Response Error รํูปแบบใหม่
    public ResponseEntity<Object> handleNotFoundException(NotFoundException notFoundException) {

        ApiExceptionResponse apiExceptionResponse = new ApiExceptionResponse(
                notFoundException.getMessage(),
                HttpStatus.NOT_FOUND,
                ZonedDateTime.now()
        );

        return new ResponseEntity<>(apiExceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {InternalServiceException.class})
    public ResponseEntity<Object> handleInternalService(InternalServiceException interalServiceException) {
        ApiExceptionResponse apiExceptionResponse = new ApiExceptionResponse(
                interalServiceException.getMessage(),
                HttpStatus.SERVICE_UNAVAILABLE,
                ZonedDateTime.now()
        );

        return new ResponseEntity<>(apiExceptionResponse, HttpStatus.SERVICE_UNAVAILABLE);
    }

    @ExceptionHandler(value = {DuplicationException.class})
    public ResponseEntity<Object> handleDuplicationException(DuplicationException duplicationException) {
        ApiExceptionResponse apiExceptionResponse = new ApiExceptionResponse(
                duplicationException.getMessage(),
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now()
        );

        return new ResponseEntity<>(apiExceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {BadRequestException.class})
    public ResponseEntity<Object> handleBadRequestException(BadRequestException badRequestException) {
        ApiExceptionResponse apiExceptionResponse = new ApiExceptionResponse(
                badRequestException.getMessage(),
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now()
        );

        return new ResponseEntity<>(apiExceptionResponse, HttpStatus.BAD_REQUEST);
    }


}
