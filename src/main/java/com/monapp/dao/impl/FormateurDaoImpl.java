package com.monapp.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.monapp.dao.FormateurDao;
import com.monapp.entity.Formateur;

@Transactional
@Repository
public class FormateurDaoImpl implements FormateurDao {
	
	@PersistenceContext
	EntityManager em;

	@Override
	public Formateur findByPrimaryKey(Integer id) {
		return em.find(Formateur.class, id);
	}

	@Override
	public List<Formateur> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Formateur> crit = cb.createQuery(Formateur.class);
		Root<Formateur> r = crit.from(Formateur.class);
		crit.select(r);
		return em.createQuery(crit).getResultList();
	}

	@Override
	public Formateur save(Formateur entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public Formateur update(Formateur entity) {
		return em.merge(entity);
	}

	@Override
	public void delete(Formateur entity) {
		entity = em.merge(entity);
		em.remove(entity);
	}

}
