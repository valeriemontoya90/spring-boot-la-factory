package com.monapp.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Formateur> cq = cb.createQuery(Formateur.class);
		Root<Formateur> model = cq.from(Formateur.class);
		cq.where(cb.equal(model.get("id"), id));
		TypedQuery<Formateur> q = em.createQuery(cq);
		return q.getSingleResult();
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Formateur entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public Formateur update(Formateur entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
