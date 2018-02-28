package com.monapp.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "technicien")
@DiscriminatorValue("technicien")
public class Technicien extends RH {

	@Column
	@OneToMany(mappedBy = "technicien", fetch = FetchType.EAGER)
	@JsonView(Views.TechnicienWithMateriel.class)
	private List<Materiel> materiel = new ArrayList<>();

	public Technicien() {
		super();

	}

	public Technicien(List<Materiel> materiel) {
		super();
		this.materiel = materiel;
	}

	public List<Materiel> getMateriel() {
		return materiel;
	}

	public void setMateriel(List<Materiel> materiel) {
		this.materiel = materiel;
	}

}
