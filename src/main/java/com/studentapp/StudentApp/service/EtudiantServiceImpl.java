package com.studentapp.StudentApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentapp.StudentApp.dao.EtudiantRepository;
import com.studentapp.StudentApp.model.Etudiant;

@Service
public class EtudiantServiceImpl implements EtudiantService {
	
	@Autowired
	private EtudiantRepository etudiantRepository;

	@Override
	public Etudiant addEtudiant(Etudiant etd) {
		// TODO Auto-generated method stub
		return etudiantRepository.save(etd);
	}

}
