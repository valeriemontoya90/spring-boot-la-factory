package com.monapp.entity;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, name = "type_materiel")
@DiscriminatorValue("materiel")

public abstract class Materiel {
	
	@Id
	@GeneratedValue(generator="materiel_seq")
	@SequenceGenerator(name="materiel_seq", sequenceName="materiel_seq", allocationSize=1)
	private int id;
	
	private String code;
	private Double cout;
	private Boolean isDisponible;
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

	public TypeMateriel getType() {
		return type;
	}

	public void setType(TypeMateriel type) {
		this.type = type;
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
	
	
}
