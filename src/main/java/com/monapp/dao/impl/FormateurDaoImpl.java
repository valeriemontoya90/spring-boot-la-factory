package com.monapp.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
		return em.find(Formateur.class, id);
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
	public List<Formateur> findAllByMatiereId(Integer matiereId) {
		String querystring = "SELECT F.id, F.nom, F.prenom, F.adresse, F.codePostal, F.mail FROM RH F "
				+ "WHERE F.id IN "
				+ "(SELECT C.formateur.id "
				+ "FROM Competence C "
				+ "WHERE C.matiere.id = "+matiereId+")";
		Query query = em.createQuery(querystring);
		List<Formateur> liste = query.getResultList();
		return liste;
	}

	@Override
	public Formateur save(Formateur entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public Formateur update(Formateur entity) {
		return em.merge(entity);
	}

	@Override
	public void delete(Formateur entity) {
		entity = em.merge(entity);
		em.remove(entity);
	}

}
