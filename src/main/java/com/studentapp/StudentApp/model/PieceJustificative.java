package com.studentapp.StudentApp.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class PieceJustificative {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String cheminFichier;

	private String intitule;

	private Date dateLivraison;

	private int etat;

	private String source;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "absence_piece", 
	joinColumns = @JoinColumn(name = "absence_id", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "piece_id", referencedColumnName = "id"))
	private List<Absence> absences;

	public PieceJustificative() {
	}

	public long getId() {
		return id;
	}

	public void setId(long idPieceJustificative) {
		this.id = idPieceJustificative;
	}

	public String getCheminFichier() {
		return cheminFichier;
	}

	public void setCheminFichier(String cheminFichier) {
		this.cheminFichier = cheminFichier;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public Date getDateLivraison() {
		return dateLivraison;
	}

	public void setDateLivraison(Date dateLivraison) {
		this.dateLivraison = dateLivraison;
	}

	public int getEtat() {
		return etat;
	}

	public void setEtat(int etat) {
		this.etat = etat;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

}
