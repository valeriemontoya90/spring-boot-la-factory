package com.monapp.entity;

import java.util.ArrayList;
import java.util.List;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, name = "type_materiel")
public abstract class Materiel {

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

	@Column
	@OneToMany(mappedBy = "materiel", fetch = FetchType.EAGER)
	private List<MatiereMateriel> matiereMateriels = new ArrayList<>();

	@Column
	@ManyToOne(fetch = FetchType.EAGER)
	private Technicien technicien;

	@Enumerated(EnumType.STRING)
	private TypeMateriel type;

	@Version
	private int version;

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

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public TypeMateriel getType() {
		return type;
	}

	public void setType(TypeMateriel type) {
		this.type = type;
	}

	public List<MatiereMateriel> getMatiereMateriels() {
		return matiereMateriels;
	}

	public void setMatiereMateriels(List<MatiereMateriel> matiereMateriels) {
		this.matiereMateriels = matiereMateriels;
	}

	public Technicien getTechnicien() {
		return technicien;
	}

	public void setTechnicien(Technicien technicien) {
		this.technicien = technicien;
	}

}
