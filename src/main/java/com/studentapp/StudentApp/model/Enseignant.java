package com.studentapp.StudentApp.model;

import java.util.List;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name = "enseighant_id")
public class Enseignant extends Utilisateur {
	private String specialite;
	
	@OneToMany(mappedBy = "enseignant")
	private List<Absence> absences;

	public Enseignant() {
	}

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

}
