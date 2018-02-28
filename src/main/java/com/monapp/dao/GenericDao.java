package com.monapp.dao;

import java.io.Serializable;
import java.util.List;

import com.monapp.entity.Ordinateur;

public interface GenericDao <T, ID extends Serializable> {
	T findByPrimaryKey(ID id);
	List<T> findAll ();
	T save(T entity);
	void delete(T entity);
	T update(T entity);
	
}
