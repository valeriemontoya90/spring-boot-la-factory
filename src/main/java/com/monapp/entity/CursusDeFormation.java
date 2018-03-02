package com.monapp.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "cursus")
public class CursusDeFormation {

	@Id
	@GeneratedValue(generator = "cursus_seq")
	@SequenceGenerator(name = "cursus_seq", sequenceName = "cursus_seq", allocationSize = 1)
	private int id;

	@Column
	private String titre;

	@OneToMany(mappedBy = "cursusDeFormation", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Stagiaire> stagiaires = new ArrayList<>();

	@OneToMany(mappedBy = "cursusDeFormation", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Formation> formations = new ArrayList<>();

	@ManyToOne(fetch = FetchType.EAGER)
	private Gestionnaire gestionnaire;

}
