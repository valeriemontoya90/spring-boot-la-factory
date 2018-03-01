package com.monapp.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "matiere")
public class Matiere {

	@Id
	@GeneratedValue(generator = "mat_seq")
	@SequenceGenerator(name = "mat_seq", sequenceName = "mat_seq", allocationSize = 1)
	private int id;

	@Column
	private String titre;

	@Column
	private int duree;

	@Column
	private String objectif;

	@Column
	private String prerequis;

	@Column
	private String contenu;

	@OneToMany(mappedBy = "matiere", fetch = FetchType.LAZY)
	@JsonView(Views.MatiereWithCompetence.class)
	private List<Competence> competences = new ArrayList<>();

	@OneToOne(mappedBy = "matiere", fetch = FetchType.EAGER)
	@JsonView(Views.MatiereWithFormation.class)
	private Formation formation;

	@ManyToMany(fetch = FetchType.EAGER)
	@JsonView(Views.MatiereWithMateriel.class)
	private List<Materiel> listeDuMateriel = new ArrayList<>();

	public Matiere() {
		super();
	}

	public Matiere(String titre, int duree, String objectif, String prerequis, String contenu,
			List<Competence> competences, Formation formation, List<Materiel> listeDuMateriel) {
		super();
		this.titre = titre;
		this.duree = duree;
		this.objectif = objectif;
		this.prerequis = prerequis;
		this.contenu = contenu;
		this.competences = competences;
		this.formation = formation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public String getObjectif() {
		return objectif;
	}

	public void setObjectif(String objectif) {
		this.objectif = objectif;
	}

	public String getPrerequis() {
		return prerequis;
	}

	public void setPrerequis(String prerequis) {
		this.prerequis = prerequis;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public List<Competence> getCompetences() {
		return competences;
	}

	public void setCompetences(List<Competence> competences) {
		this.competences = competences;
	}

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	public List<Materiel> getListeDuMateriel() {
		return listeDuMateriel;
	}

	public void setListeDuMateriel(List<Materiel> listeDuMateriel) {
		this.listeDuMateriel = listeDuMateriel;
	}

	@Override
	public String toString() {
		return "Matiere [id=" + id + ", titre=" + titre + ", duree=" + duree + ", objectif=" + objectif + ", prerequis="
				+ prerequis + ", contenu=" + contenu + ", competences=" + competences + "]";
	}

}
