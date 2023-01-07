package sn.testspring.GestionStock.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.testspring.GestionStock.entities.Stock;

public interface StockRepository extends JpaRepository<Stock,Long> {
}
