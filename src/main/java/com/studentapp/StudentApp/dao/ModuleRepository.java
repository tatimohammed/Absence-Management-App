package com.studentapp.StudentApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentapp.StudentApp.model.Module;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Long>{
	
	public Module findByidModule(Long idModule);
}
