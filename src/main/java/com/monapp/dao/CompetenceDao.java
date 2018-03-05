package com.monapp.dao;

import java.util.List;

import com.monapp.entity.Competence;

public interface CompetenceDao extends GenericDao<Competence, Integer> {
	public List<Competence> findAllByFormateurId(Integer formateurId);
}
