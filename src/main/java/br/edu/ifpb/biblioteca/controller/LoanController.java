package br.edu.ifpb.biblioteca.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpb.biblioteca.model.Loan;
import br.edu.ifpb.biblioteca.service.LoanService;

@RestController
@RequestMapping("/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @GetMapping("/list")
    public ResponseEntity<Page<Loan>> getAllLoans(@RequestParam(value = "name", required = false) String name,
                                                  @RequestParam(defaultValue = "0") int page,
                                                  @RequestParam(defaultValue = "10") int size) {
        Page<Loan> loans;
        if (name != null) {
            loans = loanService.findLoanByName(name, page, size);
        } else {
            loans = loanService.getAllLoans(page, size);
        }

        return ResponseEntity.ok(loans);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Loan> getLoanById(@PathVariable Long id) {
        Optional<Loan> loan = loanService.getLoanById(id);

        if (loan.isPresent()) {
            return ResponseEntity.ok(loan.get());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping("/create")
    public ResponseEntity<Loan> saveLoan(@RequestParam String title,
                                         @RequestParam String name,
                                         @RequestParam String email,
                                         @RequestParam String fine,
                                         @RequestParam String loanDate,
                                         @RequestParam String returnDate,
                                         @RequestParam String returnDateReal,
                                         @RequestParam String status) {
        Loan savedLoan = loanService.saveLoan(title, name, email, fine, loanDate, returnDate, returnDateReal, status);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedLoan);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Loan> updateLoan(@PathVariable Long id,
                                           @RequestParam String title,
                                           @RequestParam String name,
                                           @RequestParam String email,
                                           @RequestParam String fine,
                                           @RequestParam String loanDate,
                                           @RequestParam String returnDate,
                                           @RequestParam String returnDateReal,
                                           @RequestParam String status) {
        Loan updatedLoan = loanService.updateLoan(id, title, name, email, fine, loanDate, returnDate, returnDateReal, status);
        return ResponseEntity.ok(updatedLoan);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteLoan(@PathVariable Long id) {
        Optional<Loan> existingLoan = loanService.getLoanById(id);
        if (existingLoan.isPresent()) {
            loanService.deleteLoan(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}