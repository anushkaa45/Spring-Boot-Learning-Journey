package com.example.LibraryManagementP01.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private String isbn;
    private Double price;
    private Integer quantity;

    public Book(){
    }

    public Book(Long id, String name, String author, String isbn, double price, Integer quality) {
        this.id = id;
        this.title = name;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
        this.quantity = quality;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public Double getPrice() {
        return price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(Integer quality) {
        this.quantity = quality;
    }

    public Integer getQuantity() {
        return quantity;
    }


}

