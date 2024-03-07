package com.sushydevalexandre_re.apirestcoursespringboot.models;

public class RegistrationDTO {
	
	private String username;
	private String nom;
	private String prenom;
	private String password;
	
	public RegistrationDTO() {
		
	}


	public RegistrationDTO(String username, String nom, String prenom, String password) {
		super();
		this.username = username;
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
	}
	
	
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


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

	public String toString() {
		return "Registration info: " +"username:" + this.username + "password:" +this.password;
	}
	
	
	
	
}
