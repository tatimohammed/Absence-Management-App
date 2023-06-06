package com.studentapp.StudentApp.dao;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentapp.StudentApp.model.Absence;
import com.studentapp.StudentApp.model.Matiere;
import com.studentapp.StudentApp.model.Niveau;

@Repository
public interface AbsenceRepository extends JpaRepository<Absence, Long>{
	
	public Set<Absence> findByniveau(Niveau niveau);
	
	public Absence findByid(Long id);
	
	
	public Set<Absence> findBymatiere(Matiere matiere);
	
	public Set<Absence> findBydateHeureDebutAbsence(Date date);
	

}
