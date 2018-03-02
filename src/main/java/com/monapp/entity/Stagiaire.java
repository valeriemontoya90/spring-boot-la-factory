package com.monapp.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "stagiaire")
@DiscriminatorValue("stagiaire")
public class Stagiaire extends RH {

	@ManyToMany(mappedBy = "stagiaires", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<CursusDeFormation> cursusDeFormations = new ArrayList<>();

	@OneToOne(fetch = FetchType.EAGER)
	@JsonView(Views.StagiaireWithOrdinateur.class)
	private Ordinateur ordinateur;

	public Stagiaire() {
		super();
	}

	public Stagiaire(List<CursusDeFormation> cursusDeFormations, Ordinateur ordinateur) {
		super();
		this.cursusDeFormations = cursusDeFormations;
		this.ordinateur = ordinateur;
	}
	
	public List<CursusDeFormation> getCursusDeFormations() {
		return cursusDeFormations;
	}

	public void setCursusDeFormations(List<CursusDeFormation> cursusDeFormations) {
		this.cursusDeFormations = cursusDeFormations;
	}

	public Ordinateur getOrdinateur() {
		return ordinateur;
	}

	public void setOrdinateur(Ordinateur ordinateur) {
		this.ordinateur = ordinateur;
	}

	@Override
	public String toString() {
		return "Stagiaire [cursusDeFormations=" + cursusDeFormations + ", ordinateur=" + ordinateur + "]";
	}
}
