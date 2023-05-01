package com.example.NewStudent.exception;

public class EmployeeAlreadyPresentException extends RuntimeException{
    public EmployeeAlreadyPresentException(String s) {
        super(s);
    }
}
