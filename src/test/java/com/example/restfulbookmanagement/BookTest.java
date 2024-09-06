package com.example.restfulbookmanagement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookTest {

    @Test
    public void testBookCreation() {
        Book book = new Book("Test Title", "Test Author", 2023);

        assertEquals("Test Title", book.getTitle());
        assertEquals("Test Author", book.getAuthor());
        assertEquals(2023, book.getPublicationYear());
    }

    @Test
    public void testSettersAndGetters() {
        Book book = new Book();

        book.setTitle("New Title");
        book.setAuthor("New Author");
        book.setPublicationYear(2021);

        assertEquals("New Title", book.getTitle());
        assertEquals("New Author", book.getAuthor());
        assertEquals(2021, book.getPublicationYear());
    }
}
