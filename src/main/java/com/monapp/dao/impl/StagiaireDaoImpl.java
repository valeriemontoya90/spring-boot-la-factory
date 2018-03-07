package com.monapp.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.monapp.dao.StagiaireDao;
import com.monapp.entity.Ordinateur;
import com.monapp.entity.Stagiaire;

@Transactional
@Repository
public class StagiaireDaoImpl implements StagiaireDao {
	@PersistenceContext
	EntityManager em;

	@Override
	public Stagiaire findByPrimaryKey(Integer id) {
		return em.find(Stagiaire.class, id);
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
		em.persist(entity);
		return entity;
	}

	@Override
	public void delete(Stagiaire entity) {
		entity = em.merge(entity);
		em.remove(entity);

	}

	@Override
	public Stagiaire update(Stagiaire entity) {
		return em.merge(entity);
	}

	@Override
	public List<Stagiaire> findAllByOrdinateurId(Integer ordinateurId) {
		String querystring = "SELECT F.id, F.nom, F.prenom, F.adresse, F.codePostal, F.mail FROM RH F "
				+ "WHERE F.id IN "
				+ "(SELECT C.formateur.id "
				+ "FROM Competence C "
				+ "WHERE C.ordinateur.id = "+ordinateurId+")";
		Query query = em.createQuery(querystring);
		List<Stagiaire> list = query.getResultList();
		return list;
	}

}
