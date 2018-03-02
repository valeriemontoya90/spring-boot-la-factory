package com.monapp.entity;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ordinateur")
@DiscriminatorValue("ordinateur")
public class Ordinateur extends Materiel {

	private Processeur processeur;
	private Integer ram;
	private Integer disqueDur;

	@Temporal(TemporalType.DATE)
	private Date anneeAchat;
	
	@OneToOne(mappedBy = "ordinateur", fetch = FetchType.EAGER)
	@JsonIgnore
	private Stagiaire stagiaire;

	public Ordinateur() {
		super();
	}

	public Ordinateur(Processeur processeur, Integer ram, Integer disqueDur, Date anneeAchat, Stagiaire stagiaire) {
		super();
		this.processeur = processeur;
		this.ram = ram;
		this.disqueDur = disqueDur;
		this.anneeAchat = anneeAchat;
		this.stagiaire = stagiaire;
	}

	public Processeur getProcesseur() {
		return processeur;
	}

	public void setProcesseur(Processeur processeur) {
		this.processeur = processeur;
	}

	public Integer getRam() {
		return ram;
	}

	public void setRam(Integer ram) {
		this.ram = ram;
	}

	public Integer getDisqueDur() {
		return disqueDur;
	}

	public void setDisqueDur(Integer disqueDur) {
		this.disqueDur = disqueDur;
	}

	public Date getAnneeAchat() {
		return anneeAchat;
	}

	public void setAnneeAchat(Date anneeAchat) {
		this.anneeAchat = anneeAchat;
	}

	public Stagiaire getStagiaire() {
		return stagiaire;
	}

	public void setStagiaire(Stagiaire stagiaire) {
		this.stagiaire = stagiaire;
	}

	@Override
	public String toString() {
		return "Ordinateur [processeur=" + processeur + ", ram=" + ram + ", disqueDur=" + disqueDur + ", anneeAchat="
				+ anneeAchat + ", stagiaire=" + stagiaire + "]";
	}

}
