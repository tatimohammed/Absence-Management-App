package com.studentapp.StudentApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentapp.StudentApp.dao.ModuleRepository;
import com.studentapp.StudentApp.model.Module;

@Service
public class ModuleServiceImpl implements ModuleService{

	@Autowired
	private ModuleRepository moduleRepository;
	
	@Override
	public List<Module> getAllModules() {
		
		return moduleRepository.findAll();
	}

	@Override
	public Module getById(Long id) {
		
		return moduleRepository.findByidModule(id);
	}

}
