package com.monapp.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.monapp.dao.CompetenceDao;
import com.monapp.dao.CursusDeFormationDao;
import com.monapp.entity.Competence;
import com.monapp.entity.CursusDeFormation;

@Repository
@Transactional
public class CursusDeFormationDaoImpl implements CursusDeFormationDao {

	@PersistenceContext
	EntityManager em;

	@Override
	public CursusDeFormation findByPrimaryKey(Integer id) {
		return em.find(CursusDeFormation.class, id);
	}

	@Override
	public List<CursusDeFormation> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<CursusDeFormation> crit = cb.createQuery(CursusDeFormation.class);
		Root<CursusDeFormation> r = crit.from(CursusDeFormation.class);
		crit.select(r);
		return em.createQuery(crit).getResultList();
	}

	@Override
	public CursusDeFormation save(CursusDeFormation entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public void delete(CursusDeFormation entity) {
		entity = em.merge(entity);
		em.remove(entity);

	}

	@Override
	public CursusDeFormation update(CursusDeFormation entity) {
		return em.merge(entity);
	}

}
