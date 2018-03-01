package com.monapp.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.monapp.dao.CompetenceDao;
import com.monapp.entity.Competence;

@Repository
@Transactional
public class CompetenceDaoImpl implements CompetenceDao {

	@PersistenceContext
	EntityManager em;

	@Override
	public Competence findByPrimaryKey(Integer id) {
		return em.find(Competence.class, id);
	}

	@Override
	public List<Competence> findAll() {
		String querystring = "SELECT c FROM Competence c ";
		Query query = em.createQuery(querystring);
		List<Competence> list = query.getResultList();
		return list;
	}

	@Override
	public Competence save(Competence entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public void delete(Competence entity) {
		entity = em.merge(entity);
		em.remove(entity);

	}

	@Override
	public Competence update(Competence entity) {
		return em.merge(entity);
	}

}
