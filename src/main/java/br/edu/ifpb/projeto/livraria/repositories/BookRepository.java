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

    public Optional<Book> findBookByName(String name) {
        Query query = Query.query(Criteria.where("TITULO").is(name));
        return Optional.ofNullable(mongoTemplate.findOne(query, Book.class));
    }
}
