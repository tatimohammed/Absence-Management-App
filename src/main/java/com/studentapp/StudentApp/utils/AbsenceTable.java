package com.studentapp.StudentApp.utils;

import java.util.Date;

public class AbsenceTable {
	
	private Long id;
	
	private String cne;
	
	private String fullName;
	
	private Date startDate;
	
	private Date endDate;
	
	private String Element;
	
	private String typeSession;
	
	private String etatAbsence;
	
	private String prof;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCne() {
		return cne;
	}

	public void setCne(String cne) {
		this.cne = cne;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getElement() {
		return Element;
	}

	public void setElement(String element) {
		Element = element;
	}

	public String getTypeSession() {
		return typeSession;
	}

	public void setTypeSession(String typeSession) {
		this.typeSession = typeSession;
	}

	public String getEtatAbsence() {
		return etatAbsence;
	}

	public void setEtatAbsence(String etatAbsence) {
		this.etatAbsence = etatAbsence;
	}

	public String getProf() {
		return prof;
	}

	public void setProf(String prof) {
		this.prof = prof;
	}
	
	
	
	

}
