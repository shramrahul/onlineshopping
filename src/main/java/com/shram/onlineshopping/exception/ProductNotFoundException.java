package com.shram.onlineshopping.exception;

import java.io.Serializable;

public class ProductNotFoundException extends Exception implements Serializable {

    private String message;

    public ProductNotFoundException(String message) {
        this.message = System.currentTimeMillis()+": "+ message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
