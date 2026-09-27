package com.example.StudentManagementP03.Service;

import com.example.StudentManagementP03.Entity.Student;
import com.example.StudentManagementP03.Exception.StudentNotFoundException;
import com.example.StudentManagementP03.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository){
        this.repository = repository;
    }

    @Override
    public Student createStudent(Student student){
        return repository.save(student);
    }

    @Override
    public List<Student> getAllStudents(){
        return repository.findAll();
    }

    @Override
    public Student getStudentById(Long id){
        return repository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student not found with id" +id));
    }

    @Override
    public Student updateStudent(Long id, Student student){

        Student existingStudent = getStudentById(id);

        existingStudent.setName(student.getName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setCourse(student.getCourse());
        existingStudent.setAge(student.getAge());
        existingStudent.setMarks(student.getMarks());

        return repository.save(existingStudent);
    }

    @Override
    public Student patchStudent(Long id, Student student){

        Student existingStudent = getStudentById(id);

        if(student.getName() != null){
            existingStudent.setName(student.getName());
        }

        if(student.getEmail() != null){
            existingStudent.setEmail(student.getEmail());
        }

        if(student.getCourse() != null){
            existingStudent.setCourse(student.getCourse());
        }

        if(student.getAge() != 0){
            existingStudent.setAge(student.getAge());
        }

        if(student.getMarks() != 0){
            existingStudent.setMarks(student.getMarks());
        }

        return repository.save(existingStudent);
    }

    @Override
    public void deleteStudent(Long id){
        Student student = getStudentById(id);

        repository.delete(student);
    }

    @Override
    public List<Student> getAllStudentByCourse(String course){
        return repository.findByCourse(course);
    }

    @Override
    public List<Student> searchStudent(String name){
        return repository.findByNameContainingIgnoreCase(name);
    }


}
