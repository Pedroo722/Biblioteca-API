package br.edu.ifpb.biblioteca.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpb.biblioteca.model.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    Page<Loan> findByName(String name, Pageable pageable);
}