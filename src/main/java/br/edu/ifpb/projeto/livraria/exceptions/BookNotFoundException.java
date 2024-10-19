package br.edu.ifpb.projeto.livraria.exceptions;


public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException() {
        super("Não foi possível encontrar o livro desejado.");
    }
}