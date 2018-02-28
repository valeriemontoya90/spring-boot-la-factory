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
import com.monapp.entity.Ordinateur;

@Transactional
@Repository
public class MaterielDaoImpl implements MaterielDao {

	@PersistenceContext
	EntityManager em;

	@Override
	public Ordinateur findByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public Materiel update(Materiel entity) {
		// TODO Auto-generated method stub
		return null;
	}




}
