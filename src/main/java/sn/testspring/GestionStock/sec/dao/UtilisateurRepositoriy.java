package sn.testspring.GestionStock.sec.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import sn.testspring.GestionStock.entities.Article;
import sn.testspring.GestionStock.sec.entities.Utilisateur;

public interface UtilisateurRepositoriy extends JpaRepository<Utilisateur,Long> {
    Utilisateur findByUsername(String username);
    Page<Utilisateur> findByNomUtilisateurContains(String kw, Pageable pageable);
}
