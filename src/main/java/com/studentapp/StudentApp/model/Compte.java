package com.studentapp.StudentApp.model;

import java.util.List;

import javax.persistence.*;

@Entity
public class Compte {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int enabled;
	
	private int accountNotExpired;
	 
	private int accountNotLocked;
	
	private String username;
	
	private String password;
	
	private boolean disconnectAccount;
	
	private boolean accepteDemandeAutorisationAbsence;
	
	private boolean affichePhoto;
	
	public String getRole() {
		return this.role.getNom();
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	private boolean afficheEmail;
	
	@ManyToMany(mappedBy = "comptes")
	private List<Conversation> conversations;
	
	@ManyToOne
	@JoinColumn(name = "utilisateur_id")
	private Utilisateur utilisateur;
	
	@OneToMany(mappedBy = "compte")
	private List<JournalisationEvenements> journalisationEvenements;
	
	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;
	
	@OneToMany(mappedBy = "compte")
	private List<Notification> notifications;
	
	@OneToMany(mappedBy = "compte")
	private List<Conversation> conversations2;
	
	@OneToMany(mappedBy = "expediteur")
	private List<Message> messages;
	
	@OneToMany(mappedBy = "destinataire")
	private List<Message> messages2;
	
	
	
	
	public Compte() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public int getAccountNotExpired() {
		return accountNotExpired;
	}

	public void setAccountNotExpired(int accountNotExpired) {
		this.accountNotExpired = accountNotExpired;
	}

	public int getAccountNotLocked() {
		return accountNotLocked;
	}

	public void setAccountNotLocked(int accountNotLocked) {
		this.accountNotLocked = accountNotLocked;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isDisconnectAccount() {
		return disconnectAccount;
	}

	public void setDisconnectAccount(boolean disconnectAccount) {
		this.disconnectAccount = disconnectAccount;
	}

	public boolean isAccepteDemandeAutorisationAbsence() {
		return accepteDemandeAutorisationAbsence;
	}

	public void setAccepteDemandeAutorisationAbsence(boolean accepteDemandeAutorisationAbsence) {
		this.accepteDemandeAutorisationAbsence = accepteDemandeAutorisationAbsence;
	}

	public boolean isAffichePhoto() {
		return affichePhoto;
	}

	public void setAffichePhoto(boolean affichePhoto) {
		this.affichePhoto = affichePhoto;
	}

	public boolean isAfficheEmail() {
		return afficheEmail;
	}

	public void setAfficheEmail(boolean afficheEmail) {
		this.afficheEmail = afficheEmail;
	}
	
	
	
	

}
