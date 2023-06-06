package com.studentapp.StudentApp.model;

import java.sql.Date;

import javax.persistence.*;

@Entity
public class JournalisationEvenements {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String details;
	
	private String adresseIP;
	
	private Date DateHeure;
	
	private String typeEvenement;
	
	private String criticite;
	
	@ManyToOne
	@JoinColumn(name = "compte_id")
	private Compte compte;
	
	public JournalisationEvenements() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getAdresseIP() {
		return adresseIP;
	}

	public void setAdresseIP(String adresseIP) {
		this.adresseIP = adresseIP;
	}

	public Date getDateHeure() {
		return DateHeure;
	}

	public void setDateHeure(Date dateHeure) {
		DateHeure = dateHeure;
	}

	public String getTypeEvenement() {
		return typeEvenement;
	}

	public void setTypeEvenement(String typeEvenement) {
		this.typeEvenement = typeEvenement;
	}

	public String getCriticite() {
		return criticite;
	}

	public void setCriticite(String criticite) {
		this.criticite = criticite;
	}

	
	
}
