package com.challenge.endpoints;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String source) {
        super(source + " Not Found!");
    }
}
