package com.monapp.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "videoProjecteur")
@DiscriminatorValue("videoProjecteur")
public class VideoProjecteur extends Materiel {

	private String typez;
	
	public VideoProjecteur() {
		super();
		this.setType(TypeMateriel.VIDEOPROJECTEUR);
	}

	public VideoProjecteur(String typez) {
		super();
		this.setType(TypeMateriel.VIDEOPROJECTEUR);
		this.typez = typez;
	}

}
