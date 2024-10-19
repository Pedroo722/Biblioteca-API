package br.edu.ifpb.projeto.livraria.controllers;


import br.edu.ifpb.projeto.livraria.dtos.*;
import br.edu.ifpb.projeto.livraria.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/livros")
public class BookController {
    @Autowired
    private BookService service;

    @GetMapping("/info/all")
    public ResponseEntity<List<BookResponseDTO>> getBooksInfo() {
        return ResponseEntity.ok(service.getBooksInformation());
    }

    // @GetMapping("/info/{author}")
    // public ResponseEntity<BookResponseDTO> getBooksInfoById(@PathVariable String year, @PathVariable String code) {
    //     return ResponseEntity.ok(service.getStationsInformationById(code, year));
    // }
}