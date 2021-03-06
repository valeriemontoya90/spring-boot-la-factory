package com.monapp.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, name = "type_materiel")
public class Materiel {

	@Id
	@GeneratedValue(generator = "materiel_seq")
	@SequenceGenerator(name = "materiel_seq", sequenceName = "materiel_seq", allocationSize = 1)
	private int id;

	@Column
	private String code;

	@Column
	private Double cout;

	@Column
	private Boolean isDisponible;

	@ManyToMany(mappedBy = "listeDuMateriel", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Matiere> matieres = new ArrayList<>();

	@ManyToOne(fetch = FetchType.EAGER)
	@JsonView(Views.MaterielWithTechnicien.class)
	private Technicien technicien;

	@Enumerated(EnumType.STRING)
	private TypeMateriel type;

	public Materiel() {
		super();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Double getCout() {
		return cout;
	}

	public void setCout(Double cout) {
		this.cout = cout;
	}

	public Boolean getIsDisponible() {
		return isDisponible;
	}

	public void setIsDisponible(Boolean isDisponible) {
		this.isDisponible = isDisponible;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TypeMateriel getType() {
		return type;
	}

	public void setType(TypeMateriel type) {
		this.type = type;
	}

	public Technicien getTechnicien() {
		return technicien;
	}

	public void setTechnicien(Technicien technicien) {
		this.technicien = technicien;
	}

	public List<Matiere> getMatieres() {
		return matieres;
	}

	public void setMatieres(List<Matiere> matieres) {
		this.matieres = matieres;
	}

}
