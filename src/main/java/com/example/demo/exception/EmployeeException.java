package com.example.demo.exception;

public class EmployeeException extends RuntimeException{
    public EmployeeException(long id){
        super("Could not find employee with id" + id);
    }
}
