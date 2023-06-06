package com.studentapp.StudentApp.model;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name = "cadre_id")
public class CadreAdministrateur extends Utilisateur {

	private String grade;
	
	public CadreAdministrateur() {
	
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	
}
