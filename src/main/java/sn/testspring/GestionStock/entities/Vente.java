package sn.testspring.GestionStock.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.testspring.GestionStock.sec.entities.Utilisateur;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Vente implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idVente;
    private String codeVente;
    private long prixUnitVente;
    private long prixTotalVente;
    private long nbreVente;
    private Date dateVente;
    @OneToOne
    private Utilisateur utilisateur;
    @OneToMany
    private List<Article> articleVente = new ArrayList<>();
    @ManyToOne
    private Stock StockVente;
}
