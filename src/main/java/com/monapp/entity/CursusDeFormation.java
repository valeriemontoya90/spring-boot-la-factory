package com.monapp.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "cursus")
public class CursusDeFormation {

	@Id
	@GeneratedValue(generator = "cursus_seq")
	@SequenceGenerator(name = "cursus_seq", sequenceName = "cursus_seq", allocationSize = 1)
	private int id;

	@Column
	private String titre;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date dateDebut;

	@Column
	@Temporal(TemporalType.DATE)
	private Date dateFin;

	@ManyToMany(fetch=FetchType.LAZY)
	@JsonView(Views.CursusDeFormationWithStagiaire.class)
	private List<Stagiaire> stagiaires = new ArrayList<>();

	@ManyToMany(fetch=FetchType.LAZY)
	@JsonView(Views.CursusDeFormationWithFormations.class)
	private List<Formation> formations = new ArrayList<>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonView(Views.CursusDeFormationWithGestionnaire.class)
	private Gestionnaire gestionnaire;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
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

	public List<Stagiaire> getStagiaires() {
		return stagiaires;
	}

	public void setStagiaires(List<Stagiaire> stagiaires) {
		this.stagiaires = stagiaires;
	}

	public List<Formation> getFormations() {
		return formations;
	}

	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}

	public Gestionnaire getGestionnaire() {
		return gestionnaire;
	}

	public void setGestionnaire(Gestionnaire gestionnaire) {
		this.gestionnaire = gestionnaire;
	}
}
