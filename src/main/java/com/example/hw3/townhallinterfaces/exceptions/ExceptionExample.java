package com.example.hw3.townhallinterfaces.exceptions;

public class ExceptionExample {

    // Our test class to demonstrate custom exception created
    public String testException(int i) throws CustomExceptionA {
        if (i ==0){
            // throw our custom exception
            throw new CustomExceptionA("Sorry, number has to be > o = than 1");
        }
        else {
            return "Thanks!";
        }
    }
}
