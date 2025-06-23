package br.edu.ifpb.biblioteca.service;

import br.edu.ifpb.biblioteca.exceptions.BookNotFoundException;
import br.edu.ifpb.biblioteca.model.Book;
import br.edu.ifpb.biblioteca.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Page<Book> getAllBooks(int page, int size) {
        return bookRepository.findAll(PageRequest.of(page, size));
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public Book saveBook(String titulo, String autor, String status, String editora, String isbn, String ano, String sinopse) {
        Book newBook = new Book();
        newBook.setTitulo(titulo);
        newBook.setAutor(autor);
        newBook.setStatus(status);
        newBook.setEditora(editora);
        newBook.setIsbn(isbn);
        newBook.setAno(ano);
        newBook.setSinopse(sinopse);

        return bookRepository.save(newBook);
    }

    public Book updateBook(Long id, String titulo, String autor, String status, String editora, String isbn, String ano, String sinopse) {
        Optional<Book> existingBook = getBookById(id);

        if(existingBook.isEmpty()) {
            throw new BookNotFoundException();
        }

        Book updatedBook = existingBook.get();
        updatedBook.setTitulo(titulo);
        updatedBook.setAutor(autor);
        updatedBook.setStatus(status);
        updatedBook.setEditora(editora);
        updatedBook.setIsbn(isbn);
        updatedBook.setAno(ano);
        updatedBook.setSinopse(sinopse);

        return bookRepository.save(updatedBook);
    }

    public void deleteBook(Long id) {
        Optional<Book> existingBook = getBookById(id);

        if(existingBook.isEmpty()) {
            throw new BookNotFoundException();
        }

        bookRepository.deleteById(id);
    }

    public Page<Book> findBookByAutor(String autor, int page, int size) {
        return bookRepository.findByAutor(autor, PageRequest.of(page, size));
    }
}
