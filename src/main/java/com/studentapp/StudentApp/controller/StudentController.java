package com.studentapp.StudentApp.controller;

import java.security.Principal;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.studentapp.StudentApp.dao.MyUserDetails;
import com.studentapp.StudentApp.model.Compte;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@GetMapping("/homeStudent")
	public String showHome(Model model, Principal principal) {
		
		MyUserDetails  userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		String nameUtilisateur = userDetails.getNom();
		
		model.addAttribute("user", nameUtilisateur);
		
		return "student/homeStudent";
	}

}
