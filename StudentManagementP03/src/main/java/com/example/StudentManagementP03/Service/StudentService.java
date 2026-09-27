package com.example.StudentManagementP03.Service;

import com.example.StudentManagementP03.Entity.Student;

import java.util.List;

public interface StudentService {

    Student createStudent(Student student);

    List<Student> getAllStudents();

    Student getStudentById(Long id);

    Student updateStudent(Long id, Student student);

    Student patchStudent(Long id, Student student);

    void deleteStudent(Long id);

    List<Student> getAllStudentByCourse(String course);

    List<Student> searchStudent(String name);
}
