package com.example.hw4.exceptions;

import com.example.hw4.models.properties.Property;

public class ExceptionExample {

    // Our test class to demonstrate custom exception created
    public String testException(int i) throws IncorrectNumberExcption {
        if (i == 0){
            // throw our custom exception
            throw new IncorrectNumberExcption("Sorry, number has to be > o = than 1");
        }
        else {
            return "Thanks!";
        }
    }

    public String testInvalidUserException (String lastName, Property property) throws InvalidUserException{
        if (property == null){
            // throw custom exception
            throw new InvalidUserException("Property owner not found, please run the program again to continue.");
        }else {
            return "Property owner found. Thanks for using app";
        }
    }
}
