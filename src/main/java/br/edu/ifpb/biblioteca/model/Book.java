package br.edu.ifpb.biblioteca.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "book")
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "titulo", nullable = false, length = 100)
    private String titulo;

    @Column(name = "autor", nullable = false, length = 100)
    private String autor;

    @Column(name = "status", nullable = false, length = 50)
    private String status;

    @Column(name = "editora", nullable = false, length = 100)
    private String editora;

    @Column(name = "isbn", nullable = false, length = 20)
    private String isbn;

    @Column(name = "ano", nullable = false, length = 4)
    private String ano;

    @Column(name = "sinopse", nullable = false, length = 500)
    private String sinopse;

}