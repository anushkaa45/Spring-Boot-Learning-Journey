package com.example.LibraryManagementP01.repository;

import com.example.LibraryManagementP01.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
