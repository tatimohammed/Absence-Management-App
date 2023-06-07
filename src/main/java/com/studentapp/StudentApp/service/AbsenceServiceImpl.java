package com.studentapp.StudentApp.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentapp.StudentApp.dao.AbsenceRepository;
import com.studentapp.StudentApp.dao.MatiereRepository;
import com.studentapp.StudentApp.model.Absence;
import com.studentapp.StudentApp.model.Matiere;
import com.studentapp.StudentApp.utils.AbsenceTable;

@Service
public class AbsenceServiceImpl implements AbsenceService{
	
	@Autowired
	private AbsenceRepository absenceRepository;
	
	@Autowired 
	private NiveauServiceImpl niveauServiceImpl;
	
	@Autowired
	private MatiereRepository matiereRepository;
	
	@Autowired
	private UtilisateurServiceImpl utilisateurServiceImpl;
	
	@Override
	public Set<Absence> getAbsenceByNiveau(Long niveauId) {
		// TODO Auto-generated method stub
		return absenceRepository.findByniveau(niveauServiceImpl.getById(niveauId));
	}

	@Override
	public Set<AbsenceTable> getAbsenceData(Set<Absence> absences) {
		Set<AbsenceTable> absenceTables = new HashSet<>();
		for (Absence a : absences) {
			AbsenceTable at = new AbsenceTable(); 
			at.setId(a.getId());
			at.setCne(a.getEtudiant().getCne());
			at.setStartDate(a.getDateHeureDebutAbsence());
			String fullName = a.getEtudiant().getPrenomFR() + " " + a.getEtudiant().getNomFR();
			
			at.setFullName(fullName);
			at.setEndDate(a.getDateHeureFinAbsence());
			if(a.getEtat() == 0) {
				at.setEtatAbsence("Not Justified");
			} else if(a.getEtat() == 1) {
				at.setEtatAbsence("Justified");
			}
			at.setProf(a.getEnseignant().getNomFR() + " " + a.getEnseignant().getPrenomFR());
			at.setTypeSession(a.getMatiere().getNom());
			at.setElement(a.getMatiere().getModule().getTitre());
			absenceTables.add(at);
		}
		return absenceTables;
	}

	@Override
	public Set<Absence> getAbsenceByMatiere(Long matiereId) {
		
		return absenceRepository.findBymatiere(matiereRepository.findByidMatiere(matiereId));
	}

	@Override
	public Set<Absence> getAbsenceByDate(Date date) {
		
		return absenceRepository.findBydateHeureDebutAbsence(date);
	}

	@Override
	public Absence getById(Long id) {
		
		return absenceRepository.findByid(id);
	}

	@Override
	public void deleteAbsence(Long absenceId) {
		
		Absence absence = getById(absenceId);
		absence.setEnseignant(null);
		absence.setEtudiant(null);
		absence.setMatiere(null);
		absence.setNiveau(null);
		absenceRepository.delete(absence);
		absenceRepository.flush();
		
	}

	@Override
	public void updateAbsence(Long absenceId, Absence absenceToUpdate, Matiere m, Date dateS, Date dateE) {
		Absence absence = getById(absenceId);
		
		absence.setDateHeureDebutAbsence(dateS);
		absence.setDateHeureFinAbsence(dateE);
		absence.setEtat(absenceToUpdate.getEtat());
		absence.setMatiere(m);
		
		absenceRepository.flush();
		
	}

	

}
