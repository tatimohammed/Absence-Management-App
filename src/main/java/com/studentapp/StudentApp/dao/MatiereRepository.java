package com.studentapp.StudentApp.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentapp.StudentApp.model.Matiere;

@Repository
public interface MatiereRepository extends JpaRepository<Matiere, Long> {
	
	public Set<Matiere> findBymodule(com.studentapp.StudentApp.model.Module module);
	
	public Matiere findByidMatiere(Long id);
}	
