package com.monapp.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.monapp.dao.TechnicienDao;
import com.monapp.entity.Materiel;
import com.monapp.entity.Technicien;

@Transactional
@Repository
public class TechnicienDaoImpl implements TechnicienDao {
	@PersistenceContext
	EntityManager em;

	@Override
	public Technicien findByPrimaryKey(Integer id) {
		return em.find(Technicien.class, id);
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
		em.persist(entity);
		return entity;
	}

	@Override
	public void delete(Technicien entity) {
		List<Materiel> materiels = entity.getMatos(); 
		for(Materiel m : materiels) 
		{ 
			m.setTechnicien(null); 
		} 
		entity = em.merge(entity);
		em.remove(entity);

	}

	@Override
	public Technicien update(Technicien entity) {
		return em.merge(entity);
	}

}
