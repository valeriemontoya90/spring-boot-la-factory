package com.monapp.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
	
	@ManyToMany(mappedBy = "disponibilites", fetch = FetchType.LAZY)
	@JsonView(Views.DisponibiliteWithFormateur.class)
	private List<Formateur> formateurs = new ArrayList<>();

	public Disponibilite() {
		super();
	}	

	public Disponibilite(Date dateDebut, Date dateFin, Formateur formateur) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
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

	public List<Formateur> getFormateurs() {
		return formateurs;
	}

	public void setFormateurs(List<Formateur> formateurs) {
		this.formateurs = formateurs;
	}

	@Override
	public String toString() {
		return "Disponibilite [id=" + id + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", formateurs="
				+ formateurs + "]";
	}
	
}
