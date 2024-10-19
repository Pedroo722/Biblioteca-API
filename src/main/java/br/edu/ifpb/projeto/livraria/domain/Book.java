package br.edu.ifpb.projeto.livraria.domain;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.annotation.Id; 
import org.springframework.data.mongodb.core.mapping.Document; 

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Document(collection = "livro") 
public class Book implements Serializable {
    
    @Id 
    @EqualsAndHashCode.Include
    private String id;

    @Field("Titulo") 
    private String title;

    @Field("Autor") 
    private String author;

    @Field("Genero") 
    private String genre;

    @Field("URL") 
    private String url;
}
