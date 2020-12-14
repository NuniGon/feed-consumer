package com.sparta.core.exceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ChecksumCRC32Exception extends RuntimeException {

    private static final long serialVersionUID = 7766415083938105563L;

    public ChecksumCRC32Exception(String e) {
        super(e);
    }
}
