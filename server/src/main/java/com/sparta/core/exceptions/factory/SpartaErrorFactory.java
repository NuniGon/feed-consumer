package com.sparta.core.exceptions.factory;

import com.sparta.core.exceptions.SpartaError;

public class SpartaErrorFactory {

    public static SpartaError newInstance(String message) {
        return new SpartaError(message);
    }
}
