package br.edu.ifpb.biblioteca.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpb.biblioteca.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Page<Client> findByName(String name, Pageable pageable);
}