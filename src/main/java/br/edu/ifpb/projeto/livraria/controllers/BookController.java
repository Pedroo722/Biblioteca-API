package br.edu.ifpb.projeto.livraria.controllers;

import br.edu.ifpb.projeto.livraria.dtos.*;
import br.edu.ifpb.projeto.livraria.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/livros")
public class BookController {
    @Autowired
    private BookService service;

    @GetMapping("/info/all")
    public ResponseEntity<String> getBooksInfo() {
        List<BookResponseDTO> books = service.getBooksInformation();
        return ResponseEntity.ok("Successfully retrieved all books: " + books);
    }

    @GetMapping("/info/author")
    public ResponseEntity<String> getBooksByAuthor(@RequestParam String author) {
        List<BookResponseDTO> books = service.getBooksByAuthor(author);
        return ResponseEntity.ok("Successfully retrieved books by author '" + author + "': " + books);
    }

    @GetMapping("/info/title")
    public ResponseEntity<String> getBookByTitle(@RequestParam String title) {
        BookResponseDTO book = service.getBookByTitle(title);
        return ResponseEntity.ok("Successfully retrieved book: " + book);
    }

    @GetMapping("/info/genre")
    public ResponseEntity<String> getBooksByGenre(@RequestParam String genre) {
        List<BookResponseDTO> books = service.getBooksByGenre(genre);
        return ResponseEntity.ok("Successfully retrieved books in genre '" + genre + "': " + books);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createBook(@RequestBody BookRequestDTO bookRequestDTO) {
        BookResponseDTO createdBook = service.createBook(bookRequestDTO);
        return ResponseEntity.ok("Successfully created book: " + createdBook);
    }

    @PutMapping("/update/title")
    public ResponseEntity<String> updateBook(@RequestParam String title, @RequestBody BookRequestDTO bookRequestDTO) {
        BookResponseDTO updatedBook = service.updateBookByTitle(title, bookRequestDTO);
        return ResponseEntity.ok("Successfully updated book: " + updatedBook);
    }

    @DeleteMapping("/delete/title")
    public ResponseEntity<String> deleteBook(@RequestParam String title) {
        service.deleteBookByTitle(title);
        String responseMessage = String.format("Successfully deleted book: %s", title);
        return ResponseEntity.ok(responseMessage);
    }
}

