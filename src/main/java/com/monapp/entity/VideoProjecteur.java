package com.monapp.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "videoProjecteur")
@DiscriminatorValue("videoProjecteur")
public class VideoProjecteur extends Materiel {

}
