package com.studentapp.StudentApp.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

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

	@Override
	public List<Etudiant> getAllEtudiants() {
		// TODO Auto-generated method stub
		return etudiantRepository.findAll();
	}

	@Override
	public Etudiant getByCne(String cne) {
		// TODO Auto-generated method stub
		return etudiantRepository.findByCne(cne);
	}

	@Override
	public Etudiant getById(Long id) {
		
		return etudiantRepository.findByid(id);
	}

	@Override
	public void updateEtudiant(Long id, Etudiant e) {
		Etudiant etd = getById(id);
		etd.setCin(e.getCin());
		etd.setCne(e.getCne());
		etd.setDateNaissance(e.getDateNaissance());
		etd.setNomAR(e.getNomAR());
		etd.setNomFR(e.getNomFR());
		etd.setEmail(e.getEmail());
		etd.setPrenomAR(e.getPrenomAR());
		etd.setPrenomFR(e.getPrenomFR());
		etd.setTele(e.getTele());
		
		etudiantRepository.save(etd);
		etudiantRepository.flush();
		
	}

}
