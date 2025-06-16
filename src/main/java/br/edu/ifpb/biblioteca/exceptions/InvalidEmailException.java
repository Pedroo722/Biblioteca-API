package br.edu.ifpb.biblioteca.exceptions;

public class InvalidEmailException extends RuntimeException {
    public InvalidEmailException() {
        super("Formato de email inválidas!");
    }
}