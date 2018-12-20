package com.blackswan.simplecrud.lib;

public class SimpleErrorHandler extends Exception {
    private String timestamp;

    public SimpleErrorHandler (String message) {
        super(message);
    }

    public String toJson() {
        return "{\"message\": \"" + getMessage() + "\"}";
    }
}
