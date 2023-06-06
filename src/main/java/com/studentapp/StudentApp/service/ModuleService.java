package com.studentapp.StudentApp.service;

import java.util.List;

import com.studentapp.StudentApp.model.Module;

public interface ModuleService {

	public List<Module> getAllModules();
	
	public Module getById(Long id);
}
