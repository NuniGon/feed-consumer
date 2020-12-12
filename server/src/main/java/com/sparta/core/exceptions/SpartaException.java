package com.sparta.core.exceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SpartaException extends RuntimeException {

    private static final long serialVersionUID = 2871890752730549743L;

    public SpartaException(String e) {
        super(e);
    }
}
