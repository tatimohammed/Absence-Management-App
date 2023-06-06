package com.studentapp.StudentApp.model;

import java.util.List;

import javax.persistence.*;

@Entity
public class Inscription {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idInscription;
	
	private int annee;
	
	private int etat;

	@OneToMany(mappedBy = "incr")
	private List<Absence> absences;
	
	@ManyToOne
	@JoinColumn(name = "niveau_id")
	private Niveau niveau;
	
	@ManyToOne
	@JoinColumn(name = "edt_id")
	private Etudiant etudiant;
	
	public Inscription() {
		
	}

	public Long getIdInscription() {
		return idInscription;
	}

	public void setIdInscription(Long idInscription) {
		this.idInscription = idInscription;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public int getEtat() {
		return etat;
	}

	public void setEtat(int etat) {
		this.etat = etat;
	}
	
	
	
}
