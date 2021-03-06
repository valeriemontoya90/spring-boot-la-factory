package com.monapp.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "technicien")
@DiscriminatorValue("technicien")
public class Technicien extends RH {

	@OneToMany(mappedBy = "technicien", fetch = FetchType.EAGER)
	@JsonIgnore
	private List<Materiel> matos = new ArrayList<>();

	public Technicien() {
		super();

	}

	public Technicien(List<Materiel> matos) {
		super();
		this.matos = matos;
	}

	public List<Materiel> getMatos() {
		return matos;
	}

	public void setMatos(List<Materiel> materiel) {
		this.matos = materiel;
	}

}
