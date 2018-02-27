package com.monapp.entity;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class Ordinateur extends Materiel {

	private Processeur processeur;
	private Integer ram;
	private Integer disqueDur;

	public Ordinateur(Processeur processeur, Integer ram, Integer disqueDur, Date anneeAchat) {
		super();
		this.processeur = processeur;
		this.ram = ram;
		this.disqueDur = disqueDur;
		this.anneeAchat = anneeAchat;
	}
	
	@Temporal(TemporalType.DATE)
	private Date anneeAchat;

	public Ordinateur() {
		super();
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

}
