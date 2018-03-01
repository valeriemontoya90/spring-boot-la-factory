package com.monapp.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.monapp.dao.MaterielDao;
import com.monapp.entity.Materiel;

@Transactional
@Repository
public class MaterielDaoImpl implements MaterielDao {

	@PersistenceContext
	EntityManager em;

	@Override
	public Materiel findByPrimaryKey(Integer id) {
		return em.find(Materiel.class, id);
	}

	@Override
	public List<Materiel> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Materiel> crit = cb.createQuery(Materiel.class);
		Root<Materiel> r = crit.from(Materiel.class);
		
		crit.select(r);
		
		return em.createQuery(crit).getResultList();
	}

	@Override
	public Materiel save(Materiel entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public void delete(Materiel entity) {
		entity = em.merge(entity);
		em.remove(entity);
	}

	@Override
	public Materiel update(Materiel entity) {
		return em.merge(entity);
	}




}
