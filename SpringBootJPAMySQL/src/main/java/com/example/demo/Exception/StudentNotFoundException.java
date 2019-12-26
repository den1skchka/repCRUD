package com.example.demo.Exception;

public class StudentNotFoundException extends Exception{
    private int student_id;

    public StudentNotFoundException(int student_id){
        super(String.format("Student is not found with id : '%s'", student_id));
    }
}
