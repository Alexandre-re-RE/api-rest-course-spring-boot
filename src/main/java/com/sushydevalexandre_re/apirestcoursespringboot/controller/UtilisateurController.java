package com.sushydevalexandre_re.apirestcoursespringboot.controller;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sushydevalexandre_re.apirestcoursespringboot.configsecurity.Role;
import com.sushydevalexandre_re.apirestcoursespringboot.models.Utilisateur;
import com.sushydevalexandre_re.apirestcoursespringboot.repository.UtilisateurRepository;



@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UtilisateurController {
	
	public UtilisateurController(UtilisateurRepository utilisateurRepository) {
		super();
		this.utilisateurRepository = utilisateurRepository;
	}
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	@PostMapping("/user/create_user/{nom}/{prenom}/{pass}/{username}")
	public ResponseEntity<Utilisateur> createUser(@PathVariable String nom, @PathVariable String prenom,@PathVariable String pass,@PathVariable String username) {
		Set<Role> roles = new HashSet<>();
		roles.add(new Role(1,"USER"));
		Utilisateur user = new Utilisateur(nom,prenom,pass,username,roles);
		utilisateurRepository.save(user);
		return ResponseEntity.ok(user);
	}
	@DeleteMapping("user/delete_user/{id}")
	public void deleteUser(@PathVariable Integer id) {
		utilisateurRepository.deleteById(id);
	}
	
	@PutMapping("user/update_user/{id}/{nom}/{prenom}/{username}")
	public ResponseEntity<Utilisateur> updateUser(@PathVariable Integer id, @PathVariable String nom, @PathVariable String prenom,@PathVariable String username) {
	    Optional<Utilisateur> utilisateurOptional = utilisateurRepository.findById(id);

	    if (utilisateurOptional.isPresent()) {
	        Utilisateur userRecuperer = utilisateurOptional.get();
	        userRecuperer.setNom(nom);
	        userRecuperer.setPrenom(prenom);
	        userRecuperer.setUsername(username);
	        Utilisateur updatedUser = utilisateurRepository.save(userRecuperer);
	        return ResponseEntity.ok(updatedUser);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	@GetMapping("user/get/{id}")
	public Utilisateur getUser(@PathVariable Integer id) {
		return utilisateurRepository.findById(id).get();
		
	}
	
	@GetMapping("/getall")
	public List<Utilisateur> getAllUser() {
		return utilisateurRepository.findAll();
	}
	
}
