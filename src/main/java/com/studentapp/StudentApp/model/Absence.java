package com.studentapp.StudentApp.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Absence {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private Date dateHeureDebutAbsence;
	
	private Date dateHeureFinAbsence;
	
	private int etat;
	
	private String typeSaisie;
	
	@OneToMany(mappedBy = "absence")
	private List<TypeSeance> typeSeances;
	
	@ManyToMany
	private List<PieceJustificative> pieceJustificatives;
	
	@ManyToOne
	@JoinColumn(name = "matiere_id")
	private Matiere matiere;
	
	@ManyToOne
	@JoinColumn(name = "inscription_id")
	private Inscription incr;
	
	@ManyToOne
	@JoinColumn(name = "enseignant_id")
	private Enseignant enseignant;
	
	@ManyToOne
	@JoinColumn(name = "niveau_id")
	private Niveau niveau;
	
	@ManyToOne
	@JoinColumn(name = "etudiant_id")
	private Etudiant etudiant;
	
	

	public List<TypeSeance> getTypeSeances() {
		return typeSeances;
	}

	public void setTypeSeances(List<TypeSeance> typeSeances) {
		this.typeSeances = typeSeances;
	}

	public List<PieceJustificative> getPieceJustificatives() {
		return pieceJustificatives;
	}

	public void setPieceJustificatives(List<PieceJustificative> pieceJustificatives) {
		this.pieceJustificatives = pieceJustificatives;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public Inscription getIncr() {
		return incr;
	}

	public void setIncr(Inscription incr) {
		this.incr = incr;
	}

	public Enseignant getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}

	public Niveau getNiveau() {
		return niveau;
	}

	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	public Absence() {

	}

	public long getId() {
		return id;
	}

	public void setId(long idAbsence) {
		this.id = idAbsence;
	}

	public Date getDateHeureDebutAbsence() {
		return dateHeureDebutAbsence;
	}

	public void setDateHeureDebutAbsence(Date dateHeureDebutAbsence) {
		this.dateHeureDebutAbsence = dateHeureDebutAbsence;
	}

	public Date getDateHeureFinAbsence() {
		return dateHeureFinAbsence;
	}

	public void setDateHeureFinAbsence(Date dateHeureFinAbsence) {
		this.dateHeureFinAbsence = dateHeureFinAbsence;
	}

	public int getEtat() {
		return etat;
	}

	public void setEtat(int etat) {
		this.etat = etat;
	}

	public String getTypeSaisie() {
		return typeSaisie;
	}

	public void setTypeSaisie(String typeSaisie) {
		this.typeSaisie = typeSaisie;
	}

}
