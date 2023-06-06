package com.studentapp.StudentApp.model;

import java.util.List;

import javax.persistence.*;

@Entity
public class Matiere {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMatiere;
	
	private String nom ;
	
	private String code ;
	
	@ManyToOne
	@JoinColumn(name = "module_id")
	private Module module;
	
	@OneToMany(mappedBy = "matiere")
	private List<Absence> absences;
	
	public Module getModule() {
		return module;
	}
	public void setModule(Module module) {
		this.module = module;
	}
	public List<Absence> getAbsences() {
		return absences;
	}
	public void setAbsences(List<Absence> absences) {
		this.absences = absences;
	}
	public Matiere() {
		
	}
	public Long getIdMatiere() {
		return idMatiere;
	}

	public void setIdMatiere(Long idMatiere) {
		this.idMatiere = idMatiere;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
}
