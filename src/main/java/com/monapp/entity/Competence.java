package com.monapp.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "competence")
public class Competence {

	@Id
	@GeneratedValue(generator = "comp_seq")
	@SequenceGenerator(name = "comp_seq", sequenceName = "comp_seq", allocationSize = 1)
	@JsonView(Views.Common.class)
	private int id;

	@Enumerated(EnumType.STRING)
	@JsonView(Views.CompetenceWithLevel.class)
	private Level level;

	@ManyToOne
	@JsonView(Views.CompetenceWithMatiere.class)
	private Matiere matiere;

	@ManyToOne
	@JsonView(Views.CompetenceWithFormateur.class)
	private Formateur formateur;

	public Competence() {
		super();
	}

	public Competence(int id, Level level, Matiere matiere, Formateur formateur) {
		super();
		this.id = id;
		this.level = level;
		this.matiere = matiere;
		this.formateur = formateur;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public Formateur getFormateur() {
		return formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}

	@Override
	public String toString() {
		return "Competence [id=" + id + ", matiere=" + matiere + ", level=" + level + "]";
	}
}