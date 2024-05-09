package com.blu.app.api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "genre")
    private String genre;

    @Column(name = "publicationYear")
    private int publicationYear;

    @Column(name = "price")
    private double price;

    public Book() {
    }


    public Book(String title, String author, String genre, int publicationYear, double price) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publicationYear = publicationYear;
        this.price = price;
    }


    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }


    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }


    public void setAuthor(String author) {
        this.author = author;
    }
    public String getAuthor() {
        return author;
    }


    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String getGenre() {
        return genre;
    }


    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }
    public int getPublicationYear() {
        return publicationYear;
    }


    public void setPrice(double price) {
        this.price = price;
    }
     public double getPrice() {
        return price;
    }



}