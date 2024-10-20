package br.edu.ifpb.projeto.livraria.repositories;


import br.edu.ifpb.projeto.livraria.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class BookRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Book> findAll() {
        return mongoTemplate.findAll(Book.class);
    }    

    public Optional<Book> findBookByTitle(String title) {
        Query query = Query.query(Criteria.where("Titulo").is(title));
        return Optional.ofNullable(mongoTemplate.findOne(query, Book.class));
    }

    public List<Book> findBooksByAuthor(String author) {
        Query query = Query.query(Criteria.where("Autor").is(author));
        return mongoTemplate.find(query, Book.class);
    }

    public List<Book> findBooksByGenre(String genre) {
        Query query = Query.query(Criteria.where("Genero").is(genre));
        return mongoTemplate.find(query, Book.class);
    }

    public Book save(Book book) {
        return mongoTemplate.save(book);
    }

    public Optional<Book> findById(String id) {
        return Optional.ofNullable(mongoTemplate.findById(id, Book.class));
    }
    
    public void delete(Book book) {
        mongoTemplate.remove(book);
    }
}
