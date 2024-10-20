package br.edu.ifpb.projeto.livraria.dtos;

public record BookResponseDTO (
    String id,
    String title,
    String author,
    String genre,
    String url) 
{ }