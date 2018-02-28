package com.monapp.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.monapp.dao.SalleDao;
import com.monapp.entity.Salle;

@Transactional
@Repository
public class SalleDaoImpl implements SalleDao {

	@PersistenceContext
	EntityManager em;

	@Override
	public Salle findByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Salle> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Salle> crit = cb.createQuery(Salle.class);
		Root<Salle> r = crit.from(Salle.class);
		
		crit.select(r);
		
		return em.createQuery(crit).getResultList();
	}

	@Override
	public Salle save(Salle entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public void delete(Salle entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Salle update(Salle entity) {
		// TODO Auto-generated method stub
		return null;
	}




}
