package com.monapp.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.monapp.dao.MaterielDao;
import com.monapp.entity.Materiel;

@Transactional
@Repository
public class MatiereDaoImpl implements MaterielDao {
	@PersistenceContext
	EntityManager em;

	@Override
	public Materiel findByPrimaryKey(Integer id) {
		return em.find(Materiel.class, id);
	}

	@Override
	public List<Materiel> findAll() {
		String querystring = "SELECT a FROM Auteur a";
		Query query = em.createQuery(querystring);
		List<Materiel> list = query.getResultList();
		return list;// TODO Auto-generated method stub

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
