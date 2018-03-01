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

import com.monapp.dao.GestionnaireDao;
import com.monapp.entity.Gestionnaire;

@Transactional
@Repository
public class GestionnaireDaoImpl implements GestionnaireDao {
	@PersistenceContext
	EntityManager em;

	@Override
	public Gestionnaire findByPrimaryKey(Integer id) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Gestionnaire> cq = cb.createQuery(Gestionnaire.class);
		Root<Gestionnaire> model = cq.from(Gestionnaire.class);
		cq.where(cb.equal(model.get("id"), id));
		TypedQuery<Gestionnaire> q = em.createQuery(cq);
		return q.getSingleResult();
	}

	@Override
	public List<Gestionnaire> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Gestionnaire> crit = cb.createQuery(Gestionnaire.class);
		Root<Gestionnaire> r = crit.from(Gestionnaire.class);
		crit.select(r);
		return em.createQuery(crit).getResultList();
	}

	@Override
	public Gestionnaire save(Gestionnaire entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Gestionnaire entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public Gestionnaire update(Gestionnaire entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
