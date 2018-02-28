package com.monapp.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "matieremateriel")
public class MatiereMateriel {

	@Id
	@GeneratedValue(generator = "mam_seq")
	@SequenceGenerator(name = "mam_seq", sequenceName = "mam_seq", allocationSize = 1)
	private int id;

	@ManyToOne(fetch = FetchType.EAGER)
	private Matiere matiere;

	@ManyToOne(fetch = FetchType.EAGER)
	private Materiel materiel;

	public MatiereMateriel() {
		super();
	}

	public MatiereMateriel(Matiere matiere, Materiel materiel) {
		super();
		this.matiere = matiere;
		this.materiel = materiel;
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

	public Materiel getMateriel() {
		return materiel;
	}

	public void setMateriel(Materiel materiel) {
		this.materiel = materiel;
	}

	@Override
	public String toString() {
		return "MatiereMateriel [id=" + id + ", matiere=" + matiere + ", materiel=" + materiel + "]";
	}

}
