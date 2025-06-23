package br.edu.ifpb.biblioteca.exceptions;

public class UnauthorizedAccessException extends RuntimeException {
    public UnauthorizedAccessException() {
        super("Acesso não autorizado!");
    }
}