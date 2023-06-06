package com.studentapp.StudentApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentapp.StudentApp.model.Niveau;

@Repository
public interface NiveauRepository extends JpaRepository<Niveau, Long>{
	
	public Niveau findByidNiveau(Long id);
}
