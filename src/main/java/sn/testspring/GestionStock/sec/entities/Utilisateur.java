package sn.testspring.GestionStock.sec.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.testspring.GestionStock.entities.Stock;
import sn.testspring.GestionStock.entities.Vente;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Utilisateur implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUtilisateur;
    private String codeUtilisateur;
    private String nomUtilisateur;
    @Column(unique = true)
    private String username;
    private String password;
    private boolean active;
    private String phone;
    private String adressUtilisateur;
    private Date dateNaiss;
    @OneToMany
    private List<Vente> Ventelistes = new ArrayList<>();
    @OneToMany
    private List<Stock> stockListe = new ArrayList<>();
    @ManyToMany(fetch = FetchType.EAGER)
    private List<AppRole> appRoles= new ArrayList<>();

}
