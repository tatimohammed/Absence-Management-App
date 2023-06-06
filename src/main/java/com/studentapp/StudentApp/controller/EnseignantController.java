package com.studentapp.StudentApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/enseignant")
public class EnseignantController {
	
	@GetMapping("/homeEnseignant")
	public String showHome() {
		return "/enseignant/homeEnseignant";
	}

}
