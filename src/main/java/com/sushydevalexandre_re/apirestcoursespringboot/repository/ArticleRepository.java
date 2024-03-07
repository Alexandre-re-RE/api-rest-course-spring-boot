package com.sushydevalexandre_re.apirestcoursespringboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sushydevalexandre_re.apirestcoursespringboot.models.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer>{
	
	Article findByName(String name);
	Optional<Article> findById(Integer id);
	

}
