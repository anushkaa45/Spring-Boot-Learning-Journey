package com.example.StudentManagementPO2.Controller;

import com.example.StudentManagementPO2.Service.StudentService;
import com.example.StudentManagementPO2.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @GetMapping
    public List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteStudentById(@PathVariable Long id){
        studentService.deleteStudent(id);
        return "student deleted successfully";
    }

}
