package com.studentapp.StudentApp.model;

import java.util.List;

import javax.persistence.*;

@Entity
public class Niveau {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long idNiveau;
	
	private String alias;
	
	private String titre;
	
	@OneToMany(mappedBy = "niveau")
	private List<Module> modules;
	
	@OneToMany(mappedBy = "niveau")
	private List<Inscription> inscriptions;
	
	@ManyToOne
	@JoinColumn(name = "filiere_id")
	private Filiere filiere;
	
	@OneToMany(mappedBy = "niveau")
	private List<Absence> absences;
	
	public Niveau() {
		
	}

	public Long getIdNiveau() {
		return idNiveau;
	}

	public void setIdNiveau(Long idNiveau) {
		this.idNiveau = idNiveau;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	
}
