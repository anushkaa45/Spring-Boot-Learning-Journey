package com.example.StudentManagementP03.Exception;

public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException(String message){
        super(message);
    }
}
