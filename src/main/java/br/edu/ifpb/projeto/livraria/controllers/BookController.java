package br.edu.ifpb.projeto.livraria.controllers;

import br.edu.ifpb.projeto.livraria.dtos.*;
import br.edu.ifpb.projeto.livraria.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/livros")
public class BookController {
    @Autowired
    private BookService service;

    @GetMapping("/info/all")
    public ResponseEntity<List<BookResponseDTO>> getBooksInfo() {
        return ResponseEntity.ok(service.getBooksInformation());
    }

    @GetMapping("/info/author")
    public ResponseEntity<List<BookResponseDTO>> getBooksByAuthor(@RequestParam String author) {
        return ResponseEntity.ok(service.getBooksByAuthor(author));
    }

    @GetMapping("/info/title")
    public ResponseEntity<BookResponseDTO> getBookByTitle(@RequestParam String title) {
        return ResponseEntity.ok(service.getBookByTitle(title));
    }

    @GetMapping("/info/genre")
    public ResponseEntity<List<BookResponseDTO>> getBooksByGenre(@RequestParam String genre) {
        return ResponseEntity.ok(service.getBooksByGenre(genre));
    }

    @PostMapping("/create")
    public ResponseEntity<?> createBook(@RequestBody BookRequestDTO bookRequestDTO) {
        try {
            BookResponseDTO createdBook = service.createBook(bookRequestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdBook); 
        } catch (Exception e) {
            String errorMessage = "Error creating book: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage); 
        }
    }

    @PutMapping("/update/title")
    public ResponseEntity<?> updateBook(@RequestParam String title, @RequestBody BookRequestDTO bookRequestDTO) {
        try {
            BookResponseDTO updatedBook = service.updateBookByTitle(title, bookRequestDTO);
            return ResponseEntity.ok(updatedBook); 
        } catch (Exception e) {
            String errorMessage = "Error updating book: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage); 
        }
    }

    @DeleteMapping("/delete/title")
    public ResponseEntity<String> deleteBook(@RequestParam String title) {
        service.deleteBookByTitle(title);
        String responseMessage = String.format("Book: %s has been deleted", title);
        return ResponseEntity.ok(responseMessage);
    }
}