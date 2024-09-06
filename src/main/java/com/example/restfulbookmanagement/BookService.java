package com.example.restfulbookmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // Fetch all books
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Fetch a book by its ID
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    // Add a new book
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    // Update an existing book
    public Optional<Book> updateBook(Long id, Book newBookDetails) {
        return bookRepository.findById(id).map(book -> {
            book.setTitle(newBookDetails.getTitle());
            book.setAuthor(newBookDetails.getAuthor());
            book.setPublicationYear(newBookDetails.getPublicationYear());
            return bookRepository.save(book);
        });
    }

    // Delete a book by its ID
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
