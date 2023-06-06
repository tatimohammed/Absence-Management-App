package com.studentapp.StudentApp.service;

import java.util.List;

import com.studentapp.StudentApp.model.Niveau;

public interface NiveauService {

	public List<Niveau> getAllClasses();
	
	public Niveau getById(Long id);
}
