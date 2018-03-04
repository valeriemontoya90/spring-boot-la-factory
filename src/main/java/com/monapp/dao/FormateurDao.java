package com.monapp.dao;

import java.util.List;

import com.monapp.entity.Formateur;

public interface FormateurDao extends GenericDao<Formateur, Integer> {
	public List<Formateur> findAllByMatiereId(Integer matiereId);
}
