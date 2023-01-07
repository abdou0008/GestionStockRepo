package sn.testspring.GestionStock.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Categorie implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long idCategorie;
    @NotEmpty
    @Size(min = 4,max = 50)
    private String codeCategorie;
    @NotEmpty
    @Size(min = 1,max = 50)
    private String libelleCategorie;
    @OneToMany(mappedBy = "categorieArticle",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Article> articles = new ArrayList<>();
}
