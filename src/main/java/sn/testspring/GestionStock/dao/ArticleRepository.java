package sn.testspring.GestionStock.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import sn.testspring.GestionStock.entities.Article;
import sn.testspring.GestionStock.entities.Categorie;

public interface ArticleRepository extends JpaRepository<Article,Long> {
    Page<Article> findByLibelleArticleContains(String kw, Pageable pageable);

}
