package com.source.formapp.exception;

public class FormNotFoundException extends RuntimeException{
    public FormNotFoundException(String message) {
        super(message);
    }
}
