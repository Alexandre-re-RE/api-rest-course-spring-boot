package com.sushydevalexandre_re.apirestcoursespringboot.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Table(name = "ARTICLE")
@Entity
public class Article {
	
	public Article() {
		
	}
	public Article(String name, String description, List<String> arguments,
            long idUtilisateurAssigner, int quantite, String denomination,
            double quantiteDenomination) {
 this.name = name;
 this.description = description;
 this.arguments = arguments;
 this.idUtilisateurAssigner = idUtilisateurAssigner;
 this.quantite = quantite;
 this.denomination = denomination;
 this.quantiteDenomination = quantiteDenomination;
}
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    private String name;
    private String description;
    private List<String> arguments;
    private long idUtilisateurAssigner; //
    private int quantite; 
    private String denomination;
    private double quantiteDenomination;
	
    public Article copyWith(String newName, String newDescription, List<String> newArguments,
            Long newIdUtilisateurAssigner, Integer newQuantite, String newDenomination,
            Double newQuantiteDenomination) {
		return new Article(
                newName != null ? newName : this.name,
                newDescription != null ? newDescription : this.description,
                newArguments != null ? newArguments : this.arguments,
                newIdUtilisateurAssigner != null ? newIdUtilisateurAssigner : this.idUtilisateurAssigner,
                newQuantite != null ? newQuantite : this.quantite,
                newDenomination != null ? newDenomination : this.denomination,
                newQuantiteDenomination != null ? newQuantiteDenomination : this.quantiteDenomination
        );
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<String> getArguments() {
		return arguments;
	}
	public void setArguments(List<String> arguments) {
		this.arguments = arguments;
	}
	public long getIdUtilisateurAssigner() {
		return idUtilisateurAssigner;
	}
	public void setIdUtilisateurAssigner(long idUtilisateurAssigner) {
		this.idUtilisateurAssigner = idUtilisateurAssigner;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public String getDenomination() {
		return denomination;
	}
	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}
	public double getQuantiteDenomination() {
		return quantiteDenomination;
	}
	public void setQuantiteDenomination(double quantiteDenomination) {
		this.quantiteDenomination = quantiteDenomination;
	}

}
