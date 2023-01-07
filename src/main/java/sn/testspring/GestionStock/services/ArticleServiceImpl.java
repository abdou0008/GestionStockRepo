package sn.testspring.GestionStock.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sn.testspring.GestionStock.dao.*;
import sn.testspring.GestionStock.entities.*;
import sn.testspring.GestionStock.sec.entities.Utilisateur;
import sn.testspring.GestionStock.sec.dao.UtilisateurRepositoriy;

import javax.transaction.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class ArticleServiceImpl implements ArticleService{

    private ArticleRepository articleRepository;

    private CategorieRepository categorieRepository;

    private StockRepository stockRepository;

    private UtilisateurRepositoriy utilisateurRepositoriy;

    private VenteRepository venteRepository;

    public Article ajouterArticle(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public Categorie ajouterCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @Override
    public Stock ajouterStock(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public Utilisateur ajouterUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepositoriy.save(utilisateur);
    }

    @Override
    public Vente ajouterVente(Vente vente) {
        return venteRepository.save(vente );
    }
}
