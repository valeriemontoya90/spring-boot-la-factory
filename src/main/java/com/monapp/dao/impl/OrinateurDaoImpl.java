package com.monapp.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.monapp.dao.OrdinateurDao;
import com.monapp.entity.Ordinateur;

@Transactional
@Repository
public class OrinateurDaoImpl implements OrdinateurDao {

	@PersistenceContext
	EntityManager em;

	@Override
	public Ordinateur findByPrimaryKey(Integer id) {
		return em.find(Ordinateur.class, id);
	}

	@Override
	public List<Ordinateur> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Ordinateur> crit = cb.createQuery(Ordinateur.class);
		Root<Ordinateur> r = crit.from(Ordinateur.class);
		
		crit.select(r);
		
		return em.createQuery(crit).getResultList();
	}



	@Override
	public Ordinateur save(Ordinateur entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public void delete(Ordinateur entity) {
		entity = em.merge(entity);
		em.remove(entity);
	}

	@Override
	public Ordinateur update(Ordinateur entity) {
		return em.merge(entity);
	}




}
