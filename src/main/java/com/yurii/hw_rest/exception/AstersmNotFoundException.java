package com.yurii.hw_rest.exception;

public class AstersmNotFoundException extends RuntimeException{

    public AstersmNotFoundException(Long id) {
        super("Could not find employee " + id);
    }
}
