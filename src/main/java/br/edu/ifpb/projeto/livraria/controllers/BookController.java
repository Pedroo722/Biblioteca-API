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
    public ResponseEntity<List<BookResponseDTO>> getBooksInfo() {
        return ResponseEntity.ok(service.getBooksInformation());
    }

    @GetMapping("/info/author/{author}")
    public ResponseEntity<List<BookResponseDTO>> getBooksByAuthor(@PathVariable String author) {
        return ResponseEntity.ok(service.getBooksByAuthor(author));
    }

    @GetMapping("/info/title/{title}")
    public ResponseEntity<BookResponseDTO> getBookByTitle(@PathVariable String title) {
        return ResponseEntity.ok(service.getBookByTitle(title));
    }

    @GetMapping("/info/genre/{genre}")
    public ResponseEntity<List<BookResponseDTO>> getBooksByGenre(@PathVariable String genre) {
        return ResponseEntity.ok(service.getBooksByGenre(genre));
    }
}
