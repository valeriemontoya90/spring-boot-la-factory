package com.monapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="materiel")
public abstract class Materiel {

	@Id
	@GeneratedValue(generator="materiel_seq")
	@SequenceGenerator(name="materiel_seq", sequenceName="materiel_seq", allocationSize=1)
	private int id;
	private String code;
	private Double cout;
	private Boolean isDisponible;
	private TypeMateriel type;

	public Materiel() {
		super();
	}

	public Materiel(String code, Double cout, Boolean isDisponible, TypeMateriel type) {
		super();
		this.code = code;
		this.cout = cout;
		this.isDisponible = isDisponible;
		this.type = type;
	}
		
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public TypeMateriel getType() {
		return type;
	}

	public void setType(TypeMateriel type) {
		this.type = type;
	}
}
