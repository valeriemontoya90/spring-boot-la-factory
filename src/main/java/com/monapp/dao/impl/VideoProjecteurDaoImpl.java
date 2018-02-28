package com.monapp.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.monapp.dao.VideoProjecteurDao;
import com.monapp.entity.VideoProjecteur;

@Transactional
@Repository
public class VideoProjecteurDaoImpl implements VideoProjecteurDao {

	@PersistenceContext
	EntityManager em;

	@Override
	public VideoProjecteur findByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VideoProjecteur> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<VideoProjecteur> crit = cb.createQuery(VideoProjecteur.class);
		Root<VideoProjecteur> r = crit.from(VideoProjecteur.class);
		
		crit.select(r);
		
		return em.createQuery(crit).getResultList();
	}

	@Override
	public VideoProjecteur save(VideoProjecteur entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public void delete(VideoProjecteur entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public VideoProjecteur update(VideoProjecteur entity) {
		// TODO Auto-generated method stub
		return null;
	}




}
