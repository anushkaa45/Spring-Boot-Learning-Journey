package com.example.LibraryManagementP01.service;

import com.example.LibraryManagementP01.dto.BookRequestDTO;
import com.example.LibraryManagementP01.dto.BookResponseDTO;
import com.example.LibraryManagementP01.entity.Book;
import com.example.LibraryManagementP01.exception.BookNotFoundException;
import com.example.LibraryManagementP01.repository.BookRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // CREATE
    public BookResponseDTO createBook(BookRequestDTO dto) {

        Book book = new Book();

        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setIsbn(dto.getIsbn());
        book.setPrice(dto.getPrice());
        book.setQuantity(dto.getQuantity());

        Book savedBook = bookRepository.save(book);

        return convertToResponseDTO(savedBook);
    }

    // GET ALL
    public List<BookResponseDTO> getAllBooks() {

        return bookRepository.findAll()
                .stream()
                .map(this::convertToResponseDTO)
                .toList();
    }

    // GET BY ID
    public BookResponseDTO getBookById(Long id) {

        Book book = bookRepository.findById(id)
                .orElseThrow(() ->
                        new BookNotFoundException(
                                "Book not found with id: " + id
                        ));

        return convertToResponseDTO(book);
    }

    // UPDATE
    public BookResponseDTO updateBook(
            Long id,
            BookRequestDTO dto) {

        Book book = bookRepository.findById(id)
                .orElseThrow(() ->
                        new BookNotFoundException(
                                "Book not found with id: " + id
                        ));

        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setIsbn(dto.getIsbn());
        book.setPrice(dto.getPrice());
        book.setQuantity(dto.getQuantity());

        Book updatedBook = bookRepository.save(book);

        return convertToResponseDTO(updatedBook);
    }

    // DELETE
    public void deleteBook(Long id) {

        Book book = bookRepository.findById(id)
                .orElseThrow(() ->
                        new BookNotFoundException(
                                "Book not found with id: " + id
                        ));

        bookRepository.delete(book);
    }

    // Entity -> Response DTO
    private BookResponseDTO convertToResponseDTO(Book book) {

        return new BookResponseDTO(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getIsbn(),
                book.getPrice(),
                book.getQuantity()
        );
    }
}