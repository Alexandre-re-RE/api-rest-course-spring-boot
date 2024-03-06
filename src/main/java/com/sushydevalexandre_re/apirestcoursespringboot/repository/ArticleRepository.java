package com.sushydevalexandre_re.apirestcoursespringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sushydevalexandre_re.apirestcoursespringboot.models.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long>{
	
	Article findByName(String name);
	Article findById(long id);
	

}
