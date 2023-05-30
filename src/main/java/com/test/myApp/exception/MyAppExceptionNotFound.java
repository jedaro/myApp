package com.test.myApp.exception;

public class MyAppExceptionNotFound extends RuntimeException {
    
    public MyAppExceptionNotFound(String exception){
        super(exception);
    }
}
