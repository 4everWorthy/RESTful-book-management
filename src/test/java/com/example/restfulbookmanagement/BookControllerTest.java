package com.example.restfulbookmanagement;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetAllBooks() {
        ResponseEntity<Book[]> response = restTemplate.getForEntity("/api/books", Book[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    public void testAddBook() {
        Book newBook = new Book("REST in Practice", "Jim Webber", 2010);
        ResponseEntity<Book> response = restTemplate.postForEntity("/api/books", newBook, Book.class);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("REST in Practice", response.getBody().getTitle());
    }

    @Test
    public void testGetBookById() {
        Book newBook = new Book("Effective Java", "Joshua Bloch", 2008);
        ResponseEntity<Book> postResponse = restTemplate.postForEntity("/api/books", newBook, Book.class);
        Long bookId = postResponse.getBody().getId();

        ResponseEntity<Book> getResponse = restTemplate.getForEntity("/api/books/" + bookId, Book.class);
        assertEquals(HttpStatus.OK, getResponse.getStatusCode());
        assertNotNull(getResponse.getBody());
        assertEquals("Effective Java", getResponse.getBody().getTitle());
    }
}
