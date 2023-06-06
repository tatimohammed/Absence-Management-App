package com.studentapp.StudentApp.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Utilisateur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nomFR;

	private String prenomFR;

	private String nomAR;

	private String prenomAR;
	
	private String cin;
	
	private String email;
	
	private String tele;
	
	private String photo;
	
	@OneToMany(mappedBy = "utilisateur")
	private List<Compte> comptes;
	
	
	public Utilisateur() {
	
	}
	
	

	public Utilisateur(String nomFR, String prenomFR, String nomAR, String prenomAR, String cin, String email,
			String tele, String photo) {
		this.nomFR = nomFR;
		this.prenomFR = prenomFR;
		this.nomAR = nomAR;
		this.prenomAR = prenomAR;
		this.cin = cin;
		this.email = email;
		this.tele = tele;
		this.photo = photo;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomFR() {
		return nomFR;
	}

	public void setNomFR(String nomFR) {
		this.nomFR = nomFR;
	}

	public String getPrenomFR() {
		return prenomFR;
	}

	public void setPrenomFR(String prenomFR) {
		this.prenomFR = prenomFR;
	}

	public String getNomAR() {
		return nomAR;
	}

	public void setNomAR(String nomAR) {
		this.nomAR = nomAR;
	}

	public String getPrenomAR() {
		return prenomAR;
	}

	public void setPrenomAR(String prenomAR) {
		this.prenomAR = prenomAR;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTele() {
		return tele;
	}

	public void setTele(String tele) {
		this.tele = tele;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

}
