package com.sushydevalexandre_re.apirestcoursespringboot.models;

public class LoginResponseDTO {
	
	private Utilisateur user;
	private String jwt;
	
	public LoginResponseDTO() {
		super();
	}

	public LoginResponseDTO(Utilisateur user, String jwt) {

		this.user = user;
		this.jwt = jwt;
	}

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

}
