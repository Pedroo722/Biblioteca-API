package br.edu.ifpb.projeto.livraria.dtos;

public record BookResponseDTO(
    String title,
    String author,
    String genre,
    String url) 
{ }