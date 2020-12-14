package com.sparta.core.exceptions;

import com.sparta.core.exceptions.factory.SpartaErrorFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExceptionController {

    @ExceptionHandler(SpartaNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public SpartaError handleSpartaNotFoundException(SpartaNotFoundException ex) {
        return SpartaErrorFactory.newInstance(ex.getMessage());
    }

    @ExceptionHandler(SpartaException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public SpartaError handleSpartaException(SpartaException ex) {
        return SpartaErrorFactory.newInstance(ex.getMessage());
    }

    @ExceptionHandler(ChecksumCRC32Exception.class)
    public SpartaError handleChecksumCRC32Exception(ChecksumCRC32Exception ex) {
        return SpartaErrorFactory.newInstance(ex.getMessage());
    }
}
