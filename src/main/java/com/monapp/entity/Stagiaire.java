package com.monapp.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "stagiaire")
@DiscriminatorValue("stagiaire")
public class Stagiaire extends RH {
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonView(Views.StagiaireWithCursusDeFormation.class)
	private CursusDeFormation cursusDeFormation;

	@OneToOne(fetch = FetchType.EAGER)
	@JsonView(Views.StagiaireWithOrdinateur.class)
	private Ordinateur ordinateur;

	public Stagiaire() {
		super();
	}

	public Stagiaire(CursusDeFormation cursusDeFormation, Ordinateur ordinateur) {
		super();
		this.cursusDeFormation = cursusDeFormation;
		this.ordinateur = ordinateur;
	}

	public CursusDeFormation getCursusDeFormation() {
		return cursusDeFormation;
	}

	public void setCursusDeformation(CursusDeFormation cursusDeFormation) {
		this.cursusDeFormation = cursusDeFormation;
	}

	public Ordinateur getOrdinateur() {
		return ordinateur;
	}

	public void setOrdinateur(Ordinateur ordinateur) {
		this.ordinateur = ordinateur;
	}

	@Override
	public String toString() {
		return "Stagiaire [cursusDeFormation=" + cursusDeFormation + ", ordinateur=" + ordinateur + "]";
	}



}
