package com.monapp.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "gestionnaire")
@DiscriminatorValue("gestionnaire")
public class Gestionnaire extends RH {

	@OneToMany(mappedBy = "gestionnaire", fetch = FetchType.EAGER)
	@JsonView(Views.GestionnaireWithCursusDeFormation.class)
	private List<CursusDeFormation> cursusDeFormations = new ArrayList<>();

	public Gestionnaire() {
		super();
	}

	public Gestionnaire(List<CursusDeFormation> cursusDeFormations) {
		super();
		this.cursusDeFormations = cursusDeFormations;
	}

	public List<CursusDeFormation> getCursusDeFormation() {
		return cursusDeFormations;
	}

	public void setCursusDeFormation(List<CursusDeFormation> cursusDeFormations) {
		this.cursusDeFormations = cursusDeFormations;
	}

	@Override
	public String toString() {
		return "Gestionnaire [cursusDeFormations=" + cursusDeFormations + "]";
	}

}
