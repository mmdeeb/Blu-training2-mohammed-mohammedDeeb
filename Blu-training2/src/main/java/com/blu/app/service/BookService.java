package com.blu.app.service;

import com.blu.app.api.model.Book;
import com.blu.app.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(int id) {
        Book book = bookRepository.findById(id).orElse(null);
        if(book==null){
            throw new ResponseStatusException(
                    org.springframework.http.HttpStatus.NOT_FOUND, "Book not found");
        }
        return book;
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> searchBooks(String keyword) {
        return bookRepository.searchByTitleOrAuthor(keyword);
    }

    public void deleteBookById(Integer id) {
        bookRepository.deleteById(id);
    }

    public boolean bookIsExist(Integer id) {
        return bookRepository.existsById(id);
    }
}
