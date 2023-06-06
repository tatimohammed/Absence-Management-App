package com.studentapp.StudentApp.model;

import java.sql.Date;

import javax.persistence.*;

@Entity
public class Coordination {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCoordination;
	
	private Date dateDebut;
	
	private Date dateFin;
	
	@ManyToOne
	@JoinColumn(name = "cordinator_id")
	public Enseignant cordinator;
	
	public Coordination() {
		
	}

	public Long getIdCoordination() {
		return idCoordination;
	}

	public void setIdCoordination(Long idCoordination) {
		this.idCoordination = idCoordination;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	
	

}
