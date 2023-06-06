package com.studentapp.StudentApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentapp.StudentApp.dao.NiveauRepository;
import com.studentapp.StudentApp.model.Niveau;

@Service
public class NiveauServiceImpl implements NiveauService{

	@Autowired
	private NiveauRepository niveauRepository;
	
	@Override
	public List<Niveau> getAllClasses() {
		
		return niveauRepository.findAll();
	}

	@Override
	public Niveau getById(Long id) {
		
		return niveauRepository.findByidNiveau(id);
	}

}
