package br.edu.ifpb.projeto.livraria.dtos;

public class BookRequestDTO {
    private String title;
    private String author;
    private String genre;
    private String url;

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getGenre() { return genre; }
    public String getUrl() { return url; }

    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setGenre(String genre) { this.genre = genre; }
    public void setUrl(String url) { this.url = url; }
}

