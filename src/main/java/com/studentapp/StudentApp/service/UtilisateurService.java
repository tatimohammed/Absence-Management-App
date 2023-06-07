package com.studentapp.StudentApp.service;

import com.studentapp.StudentApp.model.Utilisateur;

public interface UtilisateurService {
	
	public Utilisateur getById(Long id);
	
	public Utilisateur add(Utilisateur u);
}
