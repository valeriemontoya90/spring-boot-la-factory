package com.monapp.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.monapp.dao.DisponibiliteDao;
import com.monapp.entity.Disponibilite;

@Transactional
@Repository
public class DisponibiliteDaoImpl implements DisponibiliteDao {
	@PersistenceContext
	EntityManager em;

	@Override
	public Disponibilite findByPrimaryKey(Integer id) {
		return em.find(Disponibilite.class, id);
	}

	@Override
	public List<Disponibilite> findAll() {
		String querystring = "SELECT a FROM Disponibilite a";
		Query query = em.createQuery(querystring);
		List<Disponibilite> list = query.getResultList();
		return list;
	}

	@Override
	public Disponibilite save(Disponibilite entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public void delete(Disponibilite entity) {
		entity = em.merge(entity);
		em.remove(entity);

	}

	@Override
	public Disponibilite update(Disponibilite entity) {
		return em.merge(entity);
	}

}
