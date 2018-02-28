package com.monapp.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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

	@Column
	@ManyToOne
	@JsonView(Views.CompetenceWithMatiere.class)
	private Matiere matiere;

	@Column
	@Enumerated(EnumType.STRING)
	@JsonView(Views.CompetenceWithLevel.class)
	private Level level;

	@Column
	@JsonView(Views.CompetenceWithFormateur.class)
	@ManyToMany(mappedBy = "competences", fetch = FetchType.EAGER)
	private List<Formateur> formateurs = new ArrayList<>();

	public Competence() {
		super();
	}

	public Competence(Matiere matiere, Level level, List<Formateur> formateurs) {
		super();
		this.matiere = matiere;
		this.level = level;
		this.formateurs = formateurs;
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

	public List<Formateur> getFormateurs() {
		return formateurs;
	}

	public void setFormateurs(List<Formateur> formateurs) {
		this.formateurs = formateurs;
	}

	@Override
	public String toString() {
		return "Competence [id=" + id + ", matiere=" + matiere + ", level=" + level + ", formateurs=" + formateurs
				+ "]";
	}

	

}