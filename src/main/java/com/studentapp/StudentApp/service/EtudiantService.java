package com.studentapp.StudentApp.service;

import java.util.List;

import com.studentapp.StudentApp.model.Etudiant;

public interface EtudiantService {

	public Etudiant addEtudiant(Etudiant etd);

	public List<Etudiant> getAllEtudiants();

	public Etudiant getByCne(String cne);

	public Etudiant getById(Long cne);
	
	public void updateEtudiant(Long id, Etudiant e);

}
