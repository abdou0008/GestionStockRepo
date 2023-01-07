package sn.testspring.GestionStock.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import sn.testspring.GestionStock.entities.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie,Long> {
   Page<Categorie> findByLibelleCategorieContains(String kw, Pageable pageable);
}
