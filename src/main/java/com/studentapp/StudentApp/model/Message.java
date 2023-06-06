package com.studentapp.StudentApp.model;

import java.sql.Date;
import javax.persistence.*;

@Entity
public class Message {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String text;
	
	private Date dateHeure;
	
	@ManyToOne
	@JoinColumn(name = "conver_id")
	private Conversation conversation;
	
	@ManyToOne
	@JoinColumn(name = "compte_exped_id")
	private Compte expediteur;
	
	@ManyToOne
	@JoinColumn(name = "compte_dest_id")
	private Compte destinataire;
	
	
	
	
	public Message() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDateHeure() {
		return dateHeure;
	}

	public void setDateHeure(Date dateHeure) {
		this.dateHeure = dateHeure;
	}
	
	

}
