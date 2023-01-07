package sn.testspring.GestionStock;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sn.testspring.GestionStock.dao.CategorieRepository;
import sn.testspring.GestionStock.entities.Article;
import sn.testspring.GestionStock.entities.Categorie;

@SpringBootTest
class GestionStockApplicationTests {
    @Autowired
    private CategorieRepository categorieRepository;

    @Test
	public void testCreateArticle(){


    }

}
