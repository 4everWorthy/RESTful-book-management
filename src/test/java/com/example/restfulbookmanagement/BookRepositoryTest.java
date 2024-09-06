package com.example.restfulbookmanagement;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void testSaveAndFindById() {
        // Create and save a new book
        Book book = new Book("JUnit in Action", "Craig Walls", 2021);
        Book savedBook = bookRepository.save(book);

        // Fetch the book by ID
        Optional<Book> foundBook = bookRepository.findById(savedBook.getId());

        // Verify that the book is found and matches the saved book
        assertTrue(foundBook.isPresent());
        assertEquals("JUnit in Action", foundBook.get().getTitle());
        assertEquals("Craig Walls", foundBook.get().getAuthor());
        assertEquals(2021, foundBook.get().getPublicationYear());
    }
}
