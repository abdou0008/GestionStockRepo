package sn.testspring.GestionStock;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import sn.testspring.GestionStock.dao.*;
import sn.testspring.GestionStock.entities.*;
import sn.testspring.GestionStock.sec.entities.Utilisateur;
import sn.testspring.GestionStock.sec.dao.UtilisateurRepositoriy;
import sn.testspring.GestionStock.sec.services.SecurityService;
import sn.testspring.GestionStock.services.ArticleService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
@AllArgsConstructor
public class GestionStockApplication {

	private ArticleRepository repo ;
	private CategorieRepository cat;
	private UtilisateurRepositoriy repoUser;
	private StockRepository repoStock;
	private VenteRepository repoVente;

	public static void main(String[] args) {
		SpringApplication.run(GestionStockApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	//@Bean
	CommandLineRunner saveUser(SecurityService securityService){
		return args -> {
			//securityService.saveNewUser("said","12345","12345");
			//securityService.saveNewUser("yasmina","12345","12345");
			//securityService.saveNewUser("housseine","12345","12345");

			//securityService.saveNewRole("USER","");
			//securityService.saveNewRole("ADMIN","");

			//securityService.addRoleToUser("said","USER");
			//securityService.addRoleToUser("said","ADMIN");
			//securityService.addRoleToUser("yasmina","USER");
			//securityService.addRoleToUser("housseine","USER");


		};
	}

	//@Bean
	CommandLineRunner start(ArticleService articleService){
		return args -> {
			Categorie categorie11 = new Categorie();
			categorie11.setCodeCategorie("cat11");
			categorie11.setLibelleCategorie("Hidjab");

			//articleService.ajouterCategorie(categorie11);

			//ajouterArticle();
			//modifierArticle();
			//supprimerArticle();
			//ajouterUtilisateur();
			//modifierUser();
			//supprimerUser();
			//listerUser();
			//ajouterStock();
			//modifierStock();
			//supprimerStock();
			//listStock();
			//ajouterVente();
			//supprimervente();
			//modifierVente();
			//listVente();

		};
	}
	public void ajouterUtilisateur(){
		Utilisateur user = new Utilisateur();
		user.setCodeUtilisateur("user03");
		user.setNomUtilisateur("Mohamed AHMED");
		user.setAdressUtilisateur("PENDA");
		user.setPhone("3357889");
		user.setUsername("Mohamed01");
		user.setPassword("Moha04");
		//categorie.getArticles().add(art);
		//art.getCategorie()
		repoUser.save(user);

	}
	public void modifierUser(){
		long idu = 2;
		Optional<Utilisateur> optional = repoUser.findById(idu);
		if (optional.isPresent()){
			Utilisateur u = optional.get();
			System.out.println("Données actuelles");
			System.out.println("Libelle  :"+u.getAdressUtilisateur());
			u.setCodeUtilisateur("user02");
			repoUser.save(u);

		}else {
			System.out.println("article inexistant");
		}

	}
	public void supprimerUser(){
		long idus  = 2L;
		Optional<Utilisateur> optional = repoUser.findById(idus);
		if (optional.isPresent()){
			Utilisateur us = optional.get();
			System.out.println("id :"+us.getIdUtilisateur());
			repoUser.delete(us);
		}else
			System.out.println("inexistant");

	}

	public  void listerUser(){

		Utilisateur user = new Utilisateur();
		List<Utilisateur> liste =  repoUser.findAll();
		for (Utilisateur x:liste){
			System.out.println("******************************");
			System.out.println("Nom"+x.getNomUtilisateur());

		}
		System.out.println("******************************");

	}

	public void ajouterArticle(){
		Categorie categorie = cat.findById(4L).orElse(null);
		Article art = new Article();
		art.setCodeArticle("Bij01");
		art.setCouleur("or");
		art.setLibelleArticle("Collier");
		art.setSize("12");
		art.setPrix(50000);
		art.setCategorieArticle(categorie);
		 //categorie.getArticles().add(art);
		 //art.getCategorie()
		repo.save(art);

	}
	public void modifierArticle(){
		long idart = 4;
		Optional<Article> optional = repo.findById(idart);
		if (optional.isPresent()){
			Article art = optional.get();
			System.out.println("Données actuelles");
			System.out.println("Libelle  :"+art.getLibelleArticle());
			art.setCouleur("gris");
			repo.save(art);

		}else {
			System.out.println("article inexistant");
		}
	}
	public void supprimerArticle(){
		long ida  = 6L;
		Optional<Article> optional = repo.findById(ida);
		if (optional.isPresent()){
			Article ar = optional.get();
			System.out.println("id :"+ar.getIdArticle());
			repo.delete(ar);
		}else
			System.out.println("inexistant");

	}

	public  void listerArticle(){

		Article a = new Article();
		List<Article> liste =  repo.findAll();
		for (Article x:liste){
			System.out.println("******************************");
			System.out.println("Nom    "+x.getLibelleArticle());

		}
		System.out.println("******************************");

	}


	public void ajouterStock(){
		Utilisateur utilisateur = repoUser.findById(3L).orElse(null);
		long ids = 5;
		Optional<Article> optional = repo.findById(ids);
		if (optional.isPresent()){
			Article article = optional.get();
			Stock stock = new Stock();
			stock.setQtteStock(17);
			stock.setDateStock(new Date());
			stock.setArticleStock(article);
			stock.setUtilisateurStock(utilisateur);
			repoStock.save(stock);

		}else {
			System.out.println("article inexistant");
		}

	}
	public void modifierStock(){
		long id = 2;
		Optional<Stock> optional = repoStock.findById(id);
		if (optional.isPresent()){
			Stock st = optional.get();
			System.out.println("Données actuelles");
			System.out.println("id  :"+st.getIdStock());
			st.setQtteStock(26);
			st.setDateStock(new Date());
			repoStock.save(st);

		}else{
			System.out.println("article inexistant");
		}


	}
	public void supprimerStock(){
		long id  = 5;
		Optional<Stock> optional = repoStock.findById(id);
		if (optional.isPresent()){
			Stock st = optional.get();
			System.out.println("id :"+st.getIdStock());
			repoStock.delete(st);

		}else{
			System.out.println("inexistant");
		}

	}
	public  void listStock(){
	Stock s = new Stock();
	List<Stock> liste =  repoStock.findAll();
		for (Stock x:liste){
		System.out.println("******************************");
		System.out.println("quantite    "+x.getQtteStock());

	}
		System.out.println("******************************");
    }


	public void ajouterVente(){
		Utilisateur utilisateur = repoUser.findById(3L).orElse(null);
		long idst =1;
		Optional<Stock> optional = repoStock.findById(idst);
		if (optional.isPresent()){
			Stock stock = optional.get();
			Vente vt = new Vente();
			vt.setCodeVente("v01");
			vt.setDateVente(new Date());
			vt.setNbreVente(5);
			vt.setPrixUnitVente(15000);
			vt.setPrixTotalVente(vt.getPrixUnitVente()* vt.getNbreVente());
			vt.setUtilisateur(utilisateur);
			vt.setStockVente(stock);
			repoVente.save(vt);
		}
	}
	public void supprimervente(){
		long idv  = 5L;
		Optional<Vente> optional = repoVente.findById(idv);
		if (optional.isPresent()){
			Vente vt = optional.get();
			System.out.println("id :"+vt.getIdVente());
			repoVente.delete(vt);
		}else
			System.out.println("inexistant");

	}
	public void modifierVente(){
		long idvt = 6;
		Optional<Vente> optional = repoVente.findById(idvt);
		if (optional.isPresent()){
			Vente vt = optional.get();
			System.out.println("Données actuelles");
			System.out.println("id  :"+vt.getIdVente());
			vt.setNbreVente(3);
			vt.setPrixUnitVente(4900);
			vt.setPrixTotalVente(vt.getPrixUnitVente()* vt.getNbreVente());

			repoVente.save(vt);

		}else {
			System.out.println("article inexistant");
		}

	}

	public  void listVente(){
		Vente v = new Vente();
		List<Vente> liste =  repoVente.findAll();
		for (Vente x:liste){
			System.out.println("******************************");
			System.out.println("Prix    "+x.getPrixTotalVente());

		}
		System.out.println("******************************");
	}

}
