package com.monapp.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "salle")
@DiscriminatorValue("salle")
public class Salle extends Materiel {

	private Integer capacite;

	public Salle() {
		super();
	}

	public Salle(Integer capacite) {
		super();
		this.capacite = capacite;
	}

	public Integer getCapacite() {
		return capacite;
	}

	public void setCapacite(Integer capacite) {
		this.capacite = capacite;
	}

	@Override
	public String toString() {
		return "Salle [capacite=" + capacite + "]";
	}
}
