package com.studentapp.StudentApp.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.studentapp.StudentApp.model.Matiere;

public interface MatiereService {
	
	public Set<Matiere> getMatiereByModule(Long moduleId);
	
	public Matiere getMatiereByModuleAndNom(Long moduleId, String nom);

}
