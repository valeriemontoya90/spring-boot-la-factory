package com.monapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="rh")
public abstract class RH {

	@Id
	@GeneratedValue(generator="rh_seq")
	@SequenceGenerator(name="rh_seq", sequenceName="rh_seq", allocationSize=1)
	private int id;
	private String nom;
	private String prenom;
	private String adresse;
	private String codePostal;
	private String mail;

	public RH() {
		// TODO Auto-generated constructor stub
	}
	
	public RH(String nom, String prenom, String adresse, String codePostal, String mail) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.mail = mail;
	}


	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		return "RH [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", codePostal="
				+ codePostal + ", mail=" + mail + "]";
	}
}
