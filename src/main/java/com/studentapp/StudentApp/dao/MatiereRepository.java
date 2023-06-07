package com.studentapp.StudentApp.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentapp.StudentApp.model.Matiere;
import com.studentapp.StudentApp.model.Module;

@Repository
public interface MatiereRepository extends JpaRepository<Matiere, Long> {
	
	public Set<Matiere> findBymodule(Module module);
	
	public Matiere findByidMatiere(Long id);
	
	public Matiere findBymoduleAndNom(Module module, String nom);
}	
