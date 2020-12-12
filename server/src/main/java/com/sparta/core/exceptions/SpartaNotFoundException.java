package com.sparta.core.exceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SpartaNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 2871890752730549743L;

    public SpartaNotFoundException(String id, String entity) {
        super("Not found " + id + " for " + entity);
    }
}
