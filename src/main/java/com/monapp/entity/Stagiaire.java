package com.monapp.entity;

import javax.persistence.Column;
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

	@Column
	@JsonView(Views.StagiaireWithFormation.class)
	@ManyToOne(fetch = FetchType.EAGER)
	private CursusDeFormation cursusDeFormation;

	@Column
	@JsonView(Views.StagiaireWithOrdinateur.class)
	@OneToOne(fetch = FetchType.EAGER)
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
