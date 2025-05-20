package com.revolution.details.service.api.controller.advice;

import com.revolution.common.exception.ErrorEntity;
import com.revolution.details.service.api.exception.AddressNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AddressControllerAdvice {

    @ExceptionHandler(AddressNotFoundException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    ErrorEntity handleAddressNotFoundException(AddressNotFoundException exception ) {
        return new ErrorEntity(exception.getMessage(), 1600, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrorEntity handleMethodArgumentNotValidException(MethodArgumentNotValidException exception ) {
        return new ErrorEntity(exception.getMessage(), 400, HttpStatus.BAD_REQUEST);
    }
}
