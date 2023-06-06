package com.studentapp.StudentApp.dao;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.studentapp.StudentApp.model.Compte;

public class MyUserDetails implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	
	private Compte compte;
	

	public MyUserDetails(Compte compte) {
		this.compte = compte;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.singleton(new SimpleGrantedAuthority(compte.getRole()));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return compte.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return compte.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public String getNom() {
		return compte.getUtilisateur().getNomFR() +" "+ compte.getUtilisateur().getPrenomFR();
	}

}
