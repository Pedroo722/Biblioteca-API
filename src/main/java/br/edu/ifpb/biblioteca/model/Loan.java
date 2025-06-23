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
@Table(name = "loan")
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "fine", nullable = false, length = 50)
    private String fine;

    @Column(name = "loan_date", nullable = false)
    private String loanDate;

    @Column(name = "return_date", nullable = false)
    private String returnDate;

    @Column(name = "return_date_real", nullable = true)
    private String returnDateReal;

    @Column(name = "status", nullable = false, length = 50)
    private String status;

}