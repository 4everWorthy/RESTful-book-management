package com.example.restfulbookmanagement;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Test
    public void testAddAndGetBook() {
        // Add a new book
        Book newBook = new Book("Spring in Action", "Craig Walls", 2022);
        Book savedBook = bookService.addBook(newBook);

        // Fetch the book by ID
        Optional<Book> foundBook = bookService.getBookById(savedBook.getId());

        // Verify the book details
        assertTrue(foundBook.isPresent());
        assertEquals("Spring in Action", foundBook.get().getTitle());
        assertEquals("Craig Walls", foundBook.get().getAuthor());
        assertEquals(2022, foundBook.get().getPublicationYear());
    }

    @Test
    public void testGetAllBooks() {
        // Fetch all books
        List<Book> allBooks = bookService.getAllBooks();

        // Verify that books are retrieved (at least one book should be present if previous test passed)
        assertFalse(allBooks.isEmpty());
    }
}
