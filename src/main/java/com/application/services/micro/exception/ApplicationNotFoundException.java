package com.application.services.micro.exception;


public class ApplicationNotFoundException extends RuntimeException  {

    private String message;

    public ApplicationNotFoundException(String message){
        this.message= message;
    }

}
