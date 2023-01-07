package sn.testspring.GestionStock.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;



@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Article implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long idArticle;
    @Size(min = 4,max = 50)
    private String codeArticle;
    @Size(min = 2,max = 50)
    private String libelleArticle;
    private long prix;
    @Size(min = 2,max = 20)
    private String couleur;
    @Size(min = 1,max = 10)
    private String size;
    @ManyToOne
    private Categorie categorieArticle;

}
