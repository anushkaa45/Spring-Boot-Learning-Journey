package com.example.StudentManagementP01.Service;

import com.example.StudentManagementP01.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private final List<Student> students = new ArrayList<>();

    public StudentService(){
        students.add(new Student(1, "Anushka", "abc@gmail.com", "web-dev"));
        students.add(new Student(2, "Harshal", "abcd@gmail.com", "web-dev"));
    }

    //to display all students
    public List<Student> getAllStudent(){
        return students;
    }

    public Student getStudentById(int id){
        for(Student student : students){
            if(student.getId() == id){
                return student;
            }
        }
        return null;
    }

    public Student addStudent(Student student){
        students.add(student);

        return student;
    }

    public String deleteStudent(int id){
        for(Student student : students){
            if(student.getId() == id){
                students.remove(student);
                return "Student deleted Successfully";
            }
        }
        return "Student not found";
    }
}
