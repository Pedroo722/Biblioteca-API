package br.edu.ifpb.biblioteca.dto;

public record LoginResponseDTO(String message, String jwtToken, String role) {
}