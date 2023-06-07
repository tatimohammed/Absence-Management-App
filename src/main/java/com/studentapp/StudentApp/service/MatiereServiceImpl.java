package com.studentapp.StudentApp.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentapp.StudentApp.dao.MatiereRepository;
import com.studentapp.StudentApp.dao.ModuleRepository;
import com.studentapp.StudentApp.model.Matiere;
import com.studentapp.StudentApp.model.Module;

@Service
public class MatiereServiceImpl implements MatiereService{
	
	@Autowired
	private MatiereRepository matiereRepository;
	
	@Autowired
	private ModuleRepository moduleRepository;
	
	@Autowired
	private ModuleServiceImpl moduleServiceImpl;

	@Override
	public Set<Matiere> getMatiereByModule(Long moduleId) {
		
		return matiereRepository.findBymodule(moduleServiceImpl.getById(moduleId));
	}

	@Override
	public Matiere getMatiereByModuleAndNom(Long moduleId, String nom) {
		Module m = moduleRepository.findByidModule(moduleId);
		
		return matiereRepository.findBymoduleAndNom(m, nom);
	}

	

	

}
