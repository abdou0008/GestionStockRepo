package sn.testspring.GestionStock.services;

import sn.testspring.GestionStock.entities.*;
import sn.testspring.GestionStock.sec.entities.Utilisateur;

public interface ArticleService {
    Article ajouterArticle(Article article);
    Categorie ajouterCategorie(Categorie categorie);
    Stock ajouterStock(Stock stock);
    //Stock modifierStock(Stock stock);
    Utilisateur ajouterUtilisateur(Utilisateur utilisateur);
    Vente ajouterVente(Vente vente);

    //void addArticleToCategory();
}

