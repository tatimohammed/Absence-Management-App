package com.studentapp.StudentApp.model;

import javax.persistence.*;


@Entity
public class TypeSeance {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idTypeSeance;
	
	private String intitule;
	
	private String alias;

	@ManyToOne
	@JoinColumn(name = "type_seance_id")
	private Absence absence;

public TypeSeance() {
}


public long getIdTypeSeance() {
	return idTypeSeance;
}


public void setIdTypeSeance(int idTypeSeance) {
	this.idTypeSeance = idTypeSeance;
}


public String getIntitule() {
	return intitule;
}


public void setIntitule(String intitule) {
	this.intitule = intitule;
}


public String getAlias() {
	return alias;
}


public void setAlias(String alias) {
	this.alias = alias;
}


}

