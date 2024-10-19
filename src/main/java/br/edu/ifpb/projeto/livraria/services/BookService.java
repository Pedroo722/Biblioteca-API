package br.edu.ifpb.projeto.livraria.services;


import br.edu.ifpb.projeto.livraria.domain.*;
import br.edu.ifpb.projeto.livraria.dtos.*;
import br.edu.ifpb.projeto.livraria.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<BookResponseDTO> getBooksInformation() {
        return getAllBooksData()
                .stream()
                .map(this::convertToBookResponseDTO)
                .collect(Collectors.toList());
    }

    public List<BookResponseDTO> getBooksByAuthor(String author) {
        return bookRepository.findBooksByAuthor(author)
                .stream()
                .map(this::convertToBookResponseDTO)
                .collect(Collectors.toList());
    }

    public BookResponseDTO getBookByTitle(String title) {
        return bookRepository.findBookByTitle(title)
                .map(this::convertToBookResponseDTO)
                .orElseThrow(() -> new RuntimeException("Book not found with title: " + title));
    }

    public List<BookResponseDTO> getBooksByGenre(String genre) {
        return bookRepository.findBooksByGenre(genre)
                .stream()
                .map(this::convertToBookResponseDTO)
                .collect(Collectors.toList());
    }

    private List<Book> getAllBooksData() {
        List<Book> books = bookRepository.findAll();
        if (books.isEmpty()) {
            return Collections.emptyList();
        }
        return books;
    }

    private BookResponseDTO convertToBookResponseDTO(Book bookInfo) {
        return new BookResponseDTO(
                bookInfo.getTitle(),
                bookInfo.getAuthor(),
                bookInfo.getGenre(),
                bookInfo.getUrl()
        );
    }
}
