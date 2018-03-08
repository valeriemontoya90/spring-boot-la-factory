package com.monapp.dao;

import java.util.List;

import com.monapp.entity.Materiel;


public interface MaterielDao extends GenericDao<Materiel, Integer>{
	public List<Materiel> findAllByTechnicienId(Integer technicienId);
}
