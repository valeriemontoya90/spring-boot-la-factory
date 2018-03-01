package com.monapp.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Stagiaire> cq = cb.createQuery(Stagiaire.class);
		Root<Stagiaire> model = cq.from(Stagiaire.class);
		cq.where(cb.equal(model.get("id"), id));
		TypedQuery<Stagiaire> q = em.createQuery(cq);
		return q.getSingleResult();
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Stagiaire entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public Stagiaire update(Stagiaire entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
