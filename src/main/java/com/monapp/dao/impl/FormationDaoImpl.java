package com.monapp.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.monapp.dao.FormationDao;
import com.monapp.entity.Formation;

@Transactional
@Repository
public class FormationDaoImpl implements FormationDao {
	
	@PersistenceContext
	EntityManager em;

	@Override
	public Formation findByPrimaryKey(Integer id) {
		return em.find(Formation.class, id);
	}

	@Override
	public List<Formation> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Formation> crit = cb.createQuery(Formation.class);
		Root<Formation> r = crit.from(Formation.class);
		crit.select(r);
		return em.createQuery(crit).getResultList();
	}

	@Override
	public Formation save(Formation entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public Formation update(Formation entity) {
		return em.merge(entity);
	}

	@Override
	public void delete(Formation entity) {
		entity = em.merge(entity);
		em.remove(entity);
	}

}
