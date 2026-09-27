package com.example.StudentManagementPO2.Repository;

import com.example.StudentManagementPO2.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
