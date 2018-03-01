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

import com.monapp.dao.TechnicienDao;
import com.monapp.entity.Technicien;

@Transactional
@Repository
public class TechnicienDaoImpl implements TechnicienDao {
	@PersistenceContext
	EntityManager em;

	@Override
	public Technicien findByPrimaryKey(Integer id) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Technicien> cq = cb.createQuery(Technicien.class);
		Root<Technicien> model = cq.from(Technicien.class);
		cq.where(cb.equal(model.get("id"), id));
		TypedQuery<Technicien> q = em.createQuery(cq);
		return q.getSingleResult();
	}

	@Override
	public List<Technicien> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Technicien> crit = cb.createQuery(Technicien.class);
		Root<Technicien> r = crit.from(Technicien.class);
		crit.select(r);
		return em.createQuery(crit).getResultList();
	}

	@Override
	public Technicien save(Technicien entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Technicien entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public Technicien update(Technicien entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
