package br.edu.ifpb.biblioteca.exceptions;

public class InvalidCredentialsException extends RuntimeException {
    public InvalidCredentialsException() {
        super("Credenciais inválidas!");
    }
}