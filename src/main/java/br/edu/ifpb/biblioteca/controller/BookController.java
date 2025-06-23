package br.edu.ifpb.biblioteca.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpb.biblioteca.model.Book;
import br.edu.ifpb.biblioteca.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/list")
    public ResponseEntity<Page<Book>> getAllBooks(@RequestParam(value = "autor", required = false) String autor,
                                                   @RequestParam(defaultValue = "0") int page,
                                                   @RequestParam(defaultValue = "10") int size) {
        Page<Book> books;
        if (autor != null) {
            books = bookService.findBookByAutor(autor, page, size);
        } else {
            books = bookService.getAllBooks(page, size);
        }

        return ResponseEntity.ok(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Optional<Book> book = bookService.getBookById(id);

        if (book.isPresent()) {
            return ResponseEntity.ok(book.get());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping("/create")
    public ResponseEntity<Book> saveBook(@RequestParam String titulo,
                                         @RequestParam String autor,
                                         @RequestParam String status,
                                         @RequestParam String editora,
                                         @RequestParam String isbn,
                                         @RequestParam String ano,
                                         @RequestParam String sinopse) {
        Book savedBook = bookService.saveBook(titulo, autor, status, editora, isbn, ano, sinopse);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id,
                                           @RequestParam String titulo,
                                           @RequestParam String autor,
                                           @RequestParam String status,
                                           @RequestParam String editora,
                                           @RequestParam String isbn,
                                           @RequestParam String ano,
                                           @RequestParam String sinopse) {
        Book updatedBook = bookService.updateBook(id, titulo, autor, status, editora, isbn, ano, sinopse);
        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        Optional<Book> existingBook = bookService.getBookById(id);
        if (existingBook.isPresent()) {
            bookService.deleteBook(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}