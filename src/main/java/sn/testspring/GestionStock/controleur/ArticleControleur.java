package sn.testspring.GestionStock.controleur;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sn.testspring.GestionStock.dao.ArticleRepository;
import sn.testspring.GestionStock.dao.CategorieRepository;
import sn.testspring.GestionStock.entities.Article;
import sn.testspring.GestionStock.entities.Categorie;
import sn.testspring.GestionStock.sec.dao.UtilisateurRepositoriy;
import sn.testspring.GestionStock.sec.entities.Utilisateur;

import javax.validation.Valid;
import java.util.List;


@Controller
@AllArgsConstructor
public class ArticleControleur {

    private CategorieRepository categorieRepository;
    private ArticleRepository articleRepository;
    private UtilisateurRepositoriy utilisateurRepositoriy;


    @GetMapping("/user/index")
    public String showAccueilPage(Model model,
                                  @RequestParam(name="page",defaultValue = "0") int page,
                                  @RequestParam(name = "size",defaultValue = "5") int size,
                                  @RequestParam(name = "keyword",defaultValue = "") String keyword){
        Page<Categorie> pageCategories = categorieRepository.findByLibelleCategorieContains(keyword,PageRequest.of(page,size));
        model.addAttribute("ListCategorie",pageCategories.getContent());
        model.addAttribute("pages",new int[pageCategories.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword",keyword);

        return "categorieTemplate/categorie";
    }
    @GetMapping("/admin/delete")
    public String delete(Long id, String keyword,int page){
        categorieRepository.deleteById(id);
        return "redirect:/user/index?page="+page+"&keyword="+keyword;

    }

    @GetMapping("/")
    public String home(){

        return "home";
    }
    @GetMapping("/user/categories")
    @ResponseBody
    public List<Categorie> listCategories(){
        return categorieRepository.findAll();

    }
    @GetMapping("/admin/formCategorie")
    public String formCategorie(Model model){
        model.addAttribute("categorie", new Categorie());
        return "categorieTemplate/formCategorie";
    }
    @PostMapping(path = "/admin/save")
    public String save(Model model, @Valid Categorie categorie, BindingResult bindingResult,
                       @RequestParam(defaultValue="0") int page,
                       @RequestParam(defaultValue = "") String keyword){
        if(bindingResult.hasErrors()) return "categorieTemplate/formCategorie";
        categorieRepository.save(categorie);
        return "redirect:/user/index?page="+page+"&keyword="+keyword;
    }
    @GetMapping("/admin/editCategorie")
    public String editCategorie(Model model,Long id,String keyword,int page){
        Categorie categorie=categorieRepository.findById(id).orElse(null);
        if (categorie==null) throw  new RuntimeException("Categorie introuvable");
        model.addAttribute("categorie",categorie);
        model.addAttribute("page",page);
        model.addAttribute("keyword",keyword);
        return "categorieTemplate/editCategorie";
    }
    @GetMapping("/user/indexArticle")
    public String showPageArticle(Model model,
                                  @RequestParam(name="page",defaultValue = "0") int page,
                                  @RequestParam(name = "size",defaultValue = "5") int size,
                                  @RequestParam(name = "keyword",defaultValue = "") String keyword) {
        Page<Article> pageArticles = articleRepository.findByLibelleArticleContains(keyword, PageRequest.of(page, size));
        model.addAttribute("ListArticle", pageArticles.getContent());
        model.addAttribute("pages", new int[pageArticles.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);

        return "articleTemplate/article";
    }
    @GetMapping("/admin/deleteArticle")
    public String deleteArticle(Long id, String keyword,int page){
        articleRepository.deleteById(id);
        return "redirect:/user/indexArticle?page="+page+"&keyword="+keyword;

    }
    @GetMapping("/user/articles")
    @ResponseBody
    public List<Article> listArticles(){
        return articleRepository.findAll();

    }
    @GetMapping("/admin/formArticle")
    public String formArticle(Model model){
        model.addAttribute("article", new Article());
        List<Categorie> categories = categorieRepository.findAll();
        model.addAttribute("categories", categories);
        return "articleTemplate/formArticle";
    }
    @PostMapping(path = "/admin/saveArticle")
    public String saveArticle(Model model, @Valid Article article, BindingResult bindingResult,
                       @RequestParam(defaultValue="0") int page,
                       @RequestParam(defaultValue = "") String keyword){
        if(bindingResult.hasErrors()) return "articleTemplate/formArticle";
        List<Categorie> categories = categorieRepository.findAll();
        model.addAttribute("categories", categories);
        articleRepository.save(article);
        return "redirect:/user/indexArticle?page="+page+"&keyword="+keyword;
    }
    @GetMapping("/admin/editArticle")
    public String editArticle(Model model,Long id,String keyword,int page){
        Article article=articleRepository.findById(id).orElse(null);
        if (article==null) throw  new RuntimeException("Article introuvable");
        model.addAttribute("article",article);
        model.addAttribute("page",page);
        model.addAttribute("keyword",keyword);
        return "articleTemplate/editArticle";
    }

    @GetMapping("/user/indexUser")
    public String showPageUser(Model model,
                                  @RequestParam(name="page",defaultValue = "0") int page,
                                  @RequestParam(name = "size",defaultValue = "5") int size,
                                  @RequestParam(name = "keyword",defaultValue = "") String keyword) {
        Page<Utilisateur> pageUser = utilisateurRepositoriy.findByNomUtilisateurContains(keyword, PageRequest.of(page, size));
        model.addAttribute("ListUser", pageUser.getContent());
        model.addAttribute("pages", new int[pageUser.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);

        return "userTemplate/user";
    }
    @GetMapping("/admin/deleteUser")
    public String deleteUser(Long id, String keyword,int page){
        utilisateurRepositoriy.deleteById(id);
        return "redirect:/user/indexUser?page="+page+"&keyword="+keyword;

    }
    @GetMapping("/user/users")
    @ResponseBody
    public List<Utilisateur> listUsers(){
        return utilisateurRepositoriy.findAll();

    }
    @GetMapping("/admin/formUser")
    public String formUser(Model model){
        model.addAttribute("user", new Utilisateur());
        return "userTemplate/formUser";
    }
    @PostMapping(path = "/admin/saveUser")
    public String saveUser(Model model, @Valid Utilisateur utilisateur, BindingResult bindingResult,
                              @RequestParam(defaultValue="0") int page,
                              @RequestParam(defaultValue = "") String keyword){
        if(bindingResult.hasErrors()) return "userTemplate/formUser";
        utilisateurRepositoriy.save(utilisateur);
        return "redirect:/user/indexUser?page="+page+"&keyword="+keyword;
    }
    @GetMapping("/admin/editUser")
    public String editUser(Model model,Long id,String keyword,int page){
        Utilisateur utilisateur=utilisateurRepositoriy.findById(id).orElse(null);
        if (utilisateur==null) throw  new RuntimeException("Utilisateur introuvable");
        model.addAttribute("user",utilisateur);
        model.addAttribute("page",page);
        model.addAttribute("keyword",keyword);
        return "userTemplate/editUser";
    }

}
