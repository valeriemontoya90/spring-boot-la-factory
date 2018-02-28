package com.monapp.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "disponibilite")
public class Disponibilite {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.Common.class)
	private int id;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date dateFin;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonView(Views.DisponibiliteWithFormateur.class)
	private Formateur formateur;

	public Disponibilite() {
		super();
	}	

	public Disponibilite(Date dateDebut, Date dateFin, Formateur formateur) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.formateur = formateur;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public Formateur getFormateur() {
		return formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}

	@Override
	public String toString() {
		return "Disponibilite [id=" + id + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", formateur="
				+ formateur + "]";
	}
	
}
