package com.sparta.core.exceptions;

public class SpartaNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 2871890752730549743L;

    public SpartaNotFoundException(String id, String entity) {
        super("Not found " + id + " for " + entity);
    }
}
