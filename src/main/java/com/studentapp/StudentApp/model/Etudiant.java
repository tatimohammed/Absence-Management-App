package com.studentapp.StudentApp.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;

@Entity(name ="Etudiant_tab")
@PrimaryKeyJoinColumn(name = "etudiant_id")
public class Etudiant extends Utilisateur{
	
	public Etudiant() {}
	private String cne;
	
	private Date dateNaissance;
	
	@OneToMany(mappedBy = "etudiant")
	private List<Inscription> inscriptions;
	
	@OneToMany(mappedBy = "etudiant")
	private List<Absence> absences;

	public String getCne() {
		return cne;
	}

	public void setCne(String cne) {
		this.cne = cne;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	
	
}
