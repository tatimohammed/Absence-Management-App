package com.studentapp.StudentApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentapp.StudentApp.model.Compte;

@Repository
public interface CompteRepository extends JpaRepository<Compte, Long> {
	
	public Compte findCompteByUsername(String username);

}
