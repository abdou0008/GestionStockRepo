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
public class Stock implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idStock;
    private long qtteStock;
    private Date dateStock;
    @OneToOne
    private Article articleStock;
    @OneToOne
    private Utilisateur utilisateurStock;
    @ManyToMany
    private List<Vente> StockventeList=new ArrayList<>();
}
























