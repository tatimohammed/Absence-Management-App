package com.studentapp.StudentApp.model;

import java.util.List;

import javax.persistence.*;

@Entity
public class Conversation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String titre;

	private String type;

	private int etat;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "compte_convrs", joinColumns = @JoinColumn(name = "compte_id_receiver"))
	private List<Compte> comptes;
	
	@ManyToOne
	@JoinColumn(name = "compte_id")
	private Compte compte;
	
	@OneToMany(mappedBy = "conversation")
	private List<Message> messages;
	
	public Conversation() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}	

	public int getEtat() {
		return etat;
	}

	public void setEtat(int etat) {
		this.etat = etat;
	}

}
