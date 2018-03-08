package com.monapp.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.monapp.dao.MatiereDao;
import com.monapp.entity.Competence;
import com.monapp.entity.Matiere;

@Transactional
@Repository
public class MatiereDaoImpl implements MatiereDao {

    @PersistenceContext
    EntityManager em;

    @Override
    public Matiere findByPrimaryKey(Integer id) {
        return em.find(Matiere.class, id);
    }

    @Override
    public List<Matiere> findAll() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Matiere> crit = cb.createQuery(Matiere.class);
        Root<Matiere> r = crit.from(Matiere.class);
        
        crit.select(r);
        
        return em.createQuery(crit).getResultList();
    }

    @Override
    public Matiere save(Matiere entity) {
        em.persist(entity);
        return entity;
    }

    @Override
    public void delete(Matiere entity) {
		List<Competence> competences = entity.getCompetences(); 
		for(Competence c : competences) 
		{ 
			//c.setFormateur(null);
			em.remove(c);
		} 
        entity = em.merge(entity);
        em.remove(entity);
    }

    @Override
    public Matiere update(Matiere entity) {
        return em.merge(entity);
    }
}