package com.studentapp.StudentApp.model;

import java.util.List;

import javax.persistence.*;

@Entity
public class Module {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long idModule;
	
	private String titre;
	
	private String code;
	
	@OneToMany(mappedBy = "module")
	private List<Matiere> matieres;
	
	@ManyToOne
	@JoinColumn(name = "niveau_id")
	private Niveau niveau;
	
	public Module() {
		
	}

	public Long getIdModule() {
		return idModule;
	}

	public void setIdModule(Long idModule) {
		this.idModule = idModule;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
}
