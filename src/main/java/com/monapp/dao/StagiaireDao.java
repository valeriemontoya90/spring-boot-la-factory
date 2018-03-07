package com.monapp.dao;

import java.util.List;

import com.monapp.entity.Stagiaire;

public interface StagiaireDao extends GenericDao<Stagiaire, Integer> {
	public List<Stagiaire> findAllByOrdinateurId(Integer ordinateurId);
}
