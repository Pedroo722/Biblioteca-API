package br.edu.ifpb.biblioteca.exceptions;

public class LoanNotFoundException extends RuntimeException {
    public LoanNotFoundException() {
        super("Loan not found");
    }
}