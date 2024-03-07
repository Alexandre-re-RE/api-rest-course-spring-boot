package com.sushydevalexandre_re.apirestcoursespringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sushydevalexandre_re.apirestcoursespringboot.models.LoginResponseDTO;
import com.sushydevalexandre_re.apirestcoursespringboot.models.RegistrationDTO;
import com.sushydevalexandre_re.apirestcoursespringboot.models.Utilisateur;
import com.sushydevalexandre_re.apirestcoursespringboot.services.AuthentificationService;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthentificationController {
	
	@Autowired
	private AuthentificationService authentificationService;
	
	@PostMapping("/register")
	public Utilisateur registerUser(@RequestBody RegistrationDTO body) {
		return authentificationService.registerUser(body.getUsername(), body.getPassword(),body.getNom(),body.getPrenom());
	}
	
	@PostMapping("/login")
	public LoginResponseDTO loginUser(@RequestBody RegistrationDTO body) {
		
		return authentificationService.loginUser(body.getUsername(),body.getPassword());
	}
	
	@GetMapping("/me")
	public ResponseEntity<Utilisateur> getme(Authentication authentication){
		Utilisateur user = (Utilisateur) authentication.getPrincipal();
		return ResponseEntity.ok(user);
	}
}
