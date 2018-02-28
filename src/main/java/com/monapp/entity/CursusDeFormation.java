package com.monapp.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name = "cursus")
public class CursusDeFormation {
	
	@Id
	@GeneratedValue(generator = "cursus_seq")
	@SequenceGenerator(name = "cursus_seq", sequenceName = "cursus_seq", allocationSize = 1)
	private int id;
	
	@Column
	private String titre;
	
	@Column
	@OneToMany(mappedBy="cursusDeFormation", fetch=FetchType.EAGER)
	private List<Stagiaire> stagiaires= new ArrayList<>();
	
	@Column
	@ManyToMany(fetch=FetchType.EAGER)
	private List<Formation> formations =new ArrayList<>();
	
	

}
