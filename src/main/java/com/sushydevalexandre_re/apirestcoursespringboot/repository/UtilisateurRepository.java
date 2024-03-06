package com.sushydevalexandre_re.apirestcoursespringboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sushydevalexandre_re.apirestcoursespringboot.models.Utilisateur;



@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
	
    Utilisateur findByUsername(String username);
    

    Utilisateur findByNom(String nom);
    
    Optional<Utilisateur> findById(Long id);

}
