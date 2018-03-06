package com.monapp.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "formation")
public class Formation {

	@Id
	@GeneratedValue(generator = "formation_seq")
	@SequenceGenerator(name = "formation_seq", sequenceName = "formation_seq", allocationSize = 1)
	private int id;

	@Column
	@Temporal(TemporalType.DATE)
	private Date dateDebut;

	@Column
	@Temporal(TemporalType.DATE)
	private Date dateFin;

	@ManyToOne(fetch=FetchType.LAZY)
	@JsonView(Views.FormationWithCursusDeFormation.class)
	private CursusDeFormation cursusDeFormation;

	@OneToOne(fetch = FetchType.EAGER)
	@JsonView(Views.FormationWithMatiere.class)
	private Matiere matiere;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonView(Views.FormationWithFormateur.class)
	private Formateur formateur;

	public Formation() {
		super();
	}
	
	public Formation(int id, Date dateDebut, Date dateFin, CursusDeFormation cursusDeFormation, Matiere matiere,
			Formateur formateur) {
		super();
		this.id = id;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.cursusDeFormation = cursusDeFormation;
		this.matiere = matiere;
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

	public CursusDeFormation getCursusDeFormation() {
		return cursusDeFormation;
	}

	public void setCursusDeFormation(CursusDeFormation cursusDeFormation) {
		this.cursusDeFormation = cursusDeFormation;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public Formateur getFormateur() {
		return formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}

	@Override
	public String toString() {
		return "Formation [id=" + id + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", cursusDeFormation="
				+ cursusDeFormation + ", matiere=" + matiere + ", formateur=" + formateur + "]";
	}

}
