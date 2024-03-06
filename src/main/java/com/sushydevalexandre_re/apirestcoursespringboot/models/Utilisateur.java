package com.sushydevalexandre_re.apirestcoursespringboot.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "UTILISATEUR")
public class Utilisateur {
	
public Utilisateur() {
		
	}
	
	public Utilisateur(String nom,String prenom,String password, String username) {
		
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
		this.username = username;	
		};
	

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String nom;
	private String prenom;
	private String password;
	private String username;

}
