package com.example.StudentManagementPO2.Service;

import com.example.StudentManagementPO2.Repository.StudentRepository;
import com.example.StudentManagementPO2.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student){
        return studentRepository.save(student);
    }

    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id){
        return studentRepository.findById(id).orElse(null);
    }

    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }
}
