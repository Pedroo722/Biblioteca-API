package br.edu.ifpb.biblioteca.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.edu.ifpb.biblioteca.exceptions.LoanNotFoundException;
import br.edu.ifpb.biblioteca.model.Loan;
import br.edu.ifpb.biblioteca.repository.LoanRepository;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    public Page<Loan> getAllLoans(int page, int size) {
        return loanRepository.findAll(PageRequest.of(page, size));
    }

    public Optional<Loan> getLoanById(Long id) {
        return loanRepository.findById(id);
    }

    public Loan saveLoan(String title, String name, String email, String fine, String loanDate, String returnDate, String returnDateReal, String status) {
        Loan newLoan = new Loan();
        newLoan.setTitle(title);
        newLoan.setName(name);
        newLoan.setEmail(email);
        newLoan.setFine(fine);
        newLoan.setLoanDate(loanDate);
        newLoan.setReturnDate(returnDate);
        newLoan.setReturnDateReal(returnDateReal);
        newLoan.setStatus(status);

        return loanRepository.save(newLoan);
    }

    public Loan updateLoan(Long id, String title, String name, String email, String fine, String loanDate, String returnDate, String returnDateReal, String status) {
        Optional<Loan> existingLoan = getLoanById(id);

        if(existingLoan.isEmpty()) {
            throw new LoanNotFoundException();
        }

        Loan updatedLoan = existingLoan.get();
        updatedLoan.setTitle(title);
        updatedLoan.setName(name);
        updatedLoan.setEmail(email);
        updatedLoan.setFine(fine);
        updatedLoan.setLoanDate(loanDate);
        updatedLoan.setReturnDate(returnDate);
        updatedLoan.setReturnDateReal(returnDateReal);
        updatedLoan.setStatus(status);

        return loanRepository.save(updatedLoan);
    }

    public void deleteLoan(Long id) {
        Optional<Loan> existingLoan = getLoanById(id);

        if(existingLoan.isEmpty()) {
            throw new LoanNotFoundException();
        }

        loanRepository.deleteById(id);
    }

    public Page<Loan> findLoanByName(String name, int page, int size) {
        return loanRepository.findByName(name, PageRequest.of(page, size));
    }
}