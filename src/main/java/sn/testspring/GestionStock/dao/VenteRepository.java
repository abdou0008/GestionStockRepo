package sn.testspring.GestionStock.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.testspring.GestionStock.entities.Vente;

public interface VenteRepository extends JpaRepository<Vente,Long> {
}
