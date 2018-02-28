package com.monapp;

import com.monapp.dao.MaterielDao;
import com.monapp.entity.Ordinateur;
import com.monapp.entity.Processeur;
import com.monapp.entity.TypeMateriel;


public class TestBertrand {

	static MaterielDao materielDao;

	public static void main(String[] args) {

		Ordinateur ordi1 = new Ordinateur();
		System.out.println("ORDINATEUR" + ordi1 );
		
		ordi1.setCode("code");
		ordi1.setCout(2.2);
		ordi1.setIsDisponible(true);
		ordi1.setType(TypeMateriel.ORDINATEUR);
		ordi1.setDisqueDur(500);
		ordi1.setProcesseur(Processeur.INTEL_I5);
		ordi1.setRam(8);

		materielDao.save(ordi1);


		

		

	}

}
