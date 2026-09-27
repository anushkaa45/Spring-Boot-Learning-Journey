package com.example.StudentManagementP03.Repository;

import com.example.StudentManagementP03.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByCourse(String course);

    List<Student> findByNameContainingIgnoreCase(String name);
}
