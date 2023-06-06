package com.studentapp.StudentApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.studentapp.StudentApp.dao.CompteRepository;
import com.studentapp.StudentApp.dao.MyUserDetails;
import com.studentapp.StudentApp.model.Compte;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private CompteRepository compteRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Compte compte = compteRepository.findCompteByUsername(username);
		System.out.println("Username: " + username);
		System.out.println("Loading...");
		if(compte != null) {
			System.out.println("User found!");
			return new MyUserDetails(compte);
			
		} else {
			System.out.println("User Not found!");
		}
		
		throw new UsernameNotFoundException("User Not Found!!");
	}

}
