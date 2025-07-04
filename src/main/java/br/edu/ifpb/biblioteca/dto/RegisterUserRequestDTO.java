package br.edu.ifpb.biblioteca.dto;

public record RegisterUserRequestDTO(String name, String email, String password, String phone, String address) {
}