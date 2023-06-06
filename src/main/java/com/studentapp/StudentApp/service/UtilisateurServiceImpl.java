package com.studentapp.StudentApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentapp.StudentApp.dao.UtilisateurRepository;
import com.studentapp.StudentApp.model.Utilisateur;

@Service
public class UtilisateurServiceImpl implements UtilisateurService{
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	@Override
	public Utilisateur getById(Long id) {
		// TODO Auto-generated method stub
		return utilisateurRepository.findByid(id);
	}

}
