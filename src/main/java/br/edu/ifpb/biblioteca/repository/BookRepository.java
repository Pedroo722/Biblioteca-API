package br.edu.ifpb.biblioteca.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpb.biblioteca.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
    Page<Book> findByAutor(String autor, Pageable pageable);
}