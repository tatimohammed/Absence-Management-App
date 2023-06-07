package com.studentapp.StudentApp.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.studentapp.StudentApp.model.Absence;
import com.studentapp.StudentApp.model.Matiere;
import com.studentapp.StudentApp.utils.AbsenceTable;

public interface AbsenceService {
	
	public Set<Absence> getAbsenceByNiveau(Long niveauId);
	
	public Absence getById(Long id);
	
	public void deleteAbsence(Long id);
	
	public Set<Absence> getAbsenceByMatiere(Long matiereId);

	public Set<AbsenceTable> getAbsenceData(Set<Absence> absences);
	
	public Set<Absence> getAbsenceByDate(Date date);
	
	public void updateAbsence(Long id, Absence absenceToUpdate, Matiere m, Date dateS, Date dateE);
}
