package com.example.StudentManagementP03.Controller;

import com.example.StudentManagementP03.Entity.Student;
import com.example.StudentManagementP03.Service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){

        Student savedStudent = service.createStudent(student);

        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents(){
        return ResponseEntity.ok(service.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id){
        return ResponseEntity.ok(service.getStudentById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> putStudent(@PathVariable Long id, @RequestBody Student student){
        Student updateStudent = service.updateStudent(id, student);
        return ResponseEntity.ok(updateStudent);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Student> patchStudent(
            @PathVariable Long id,
            @RequestBody Student student) {

        Student updatedStudent = service.patchStudent(id, student);

        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id){
        service.deleteStudent(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/course")
    public ResponseEntity<List<Student>> getAllStudentByCourse(@RequestParam String course){
        return ResponseEntity.ok(service.getAllStudentByCourse(course));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Student>> searchStudents(@RequestParam String name){
        return ResponseEntity.ok(service.searchStudent(name));
    }
}
