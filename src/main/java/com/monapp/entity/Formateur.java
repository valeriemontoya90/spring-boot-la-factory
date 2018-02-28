package com.monapp.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "formateur")
@DiscriminatorValue("formateur")
public class Formateur extends RH {

	@Column
	@OneToMany(mappedBy = "formateur", fetch = FetchType.EAGER)
	@JsonView(Views.FormateurWithDisponibilite.class)
	private List<Disponibilite> disponibilites = new ArrayList<>();

	@Column
	@ManyToMany(fetch = FetchType.EAGER)
	@JsonView(Views.FormateurWithCompetence.class)
	private List<Competence> competences = new ArrayList<>();

	@Column
	@OneToMany(mappedBy = "formateur", fetch = FetchType.EAGER)
	@JsonView(Views.FormateurWithFormation.class)
	private List<Formation> formations = new ArrayList<>();

	public Formateur() {
		super();
	}

	public Formateur(List<Disponibilite> disponibilites, List<Competence> competences, List<Formation> formations) {
		super();
		this.disponibilites = disponibilites;
		this.competences = competences;
		this.formations = formations;
	}

	public List<Competence> getCompetences() {
		return competences;
	}

	public void setCompetences(List<Competence> competences) {
		this.competences = competences;
	}

	public List<Disponibilite> getDisponibilites() {
		return disponibilites;
	}

	public void setDisponibilites(List<Disponibilite> disponibilites) {
		this.disponibilites = disponibilites;
	}

	public List<Formation> getFormations() {
		return formations;
	}

	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}

	@Override
	public String toString() {
		return "Formateur [disponibilites=" + disponibilites + ", competences=" + competences + ", formations="
				+ formations + "]";
	}

}