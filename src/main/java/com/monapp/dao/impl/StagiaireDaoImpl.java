package com.monapp.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.monapp.dao.StagiaireDao;
import com.monapp.entity.Stagiaire;

@Transactional
@Repository
public class StagiaireDaoImpl implements StagiaireDao {
	@PersistenceContext
	EntityManager em;

	@Override
	public Stagiaire findByPrimaryKey(Integer id) {
		return em.find(Stagiaire.class, id);
	}

	@Override
	public List<Stagiaire> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Stagiaire> crit = cb.createQuery(Stagiaire.class);
		Root<Stagiaire> r = crit.from(Stagiaire.class);
		crit.select(r);
		return em.createQuery(crit).getResultList();
	}

	@Override
	public Stagiaire save(Stagiaire entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public void delete(Stagiaire entity) {
		entity = em.merge(entity);
		em.remove(entity);

	}

	@Override
	public Stagiaire update(Stagiaire entity) {
		return em.merge(entity);
	}

}
