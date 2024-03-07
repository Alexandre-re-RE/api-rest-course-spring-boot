package com.sushydevalexandre_re.apirestcoursespringboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sushydevalexandre_re.apirestcoursespringboot.models.Article;
import com.sushydevalexandre_re.apirestcoursespringboot.repository.ArticleRepository;

@RestController
@RequestMapping("/article")
@CrossOrigin("*")
public class ArticleController {
	public ArticleController(ArticleRepository articleRepository) {
		super();
		this.articleRepository = articleRepository;
	}
	@Autowired
	private ArticleRepository articleRepository;
	
	

	@PostMapping("/create_article")
	public ResponseEntity<Article> createArticle(@RequestBody Article article) {
		articleRepository.save(article);
		return ResponseEntity.ok(article);
	}
	 @DeleteMapping("/article/delete_article/{id}")
	    public void supprimerArticle(@PathVariable Integer id) {
		 articleRepository.deleteById(id);
	}
	 
	 @PutMapping("/update_article/{id}")
	    public ResponseEntity<Article> modifierArticle(@PathVariable Integer id, @RequestBody Article a) {
		   Optional<Article> articleOptional = articleRepository.findById(id);

		    if (articleOptional.isPresent()) {
		        Article articleRecuperer = articleOptional.get();
		        articleRecuperer.copyWith(a.getName(), a.getDescription(), a.getArguments(), a.getIdUtilisateurAssigner(), a.getQuantite(), a.getDenomination(), a.getQuantiteDenomination());
		        
		       
		        Article updatedArticle = articleRepository.save(articleRecuperer);
		        return ResponseEntity.ok(updatedArticle);
		    } else {
		        return ResponseEntity.notFound().build();
		    }
	 }

	 @GetMapping("/get_article/{name}")
	    public Article getArticleByName(@PathVariable  String name) {
	        return articleRepository.findByName(name);
	    }
	 
	 @GetMapping("/get_article/{id}")
	    public Optional<Article> getArticleById(@PathVariable  Integer id) {
	        return articleRepository.findById(id);
	    }
	
	@GetMapping("/getall")
	public List<Article> getAllUser() {
		return articleRepository.findAll();
	}
	

}
