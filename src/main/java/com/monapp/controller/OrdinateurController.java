package com.monapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.monapp.dao.OrdinateurDao;
import com.monapp.entity.Ordinateur;

@CrossOrigin
@RestController
public class OrdinateurController {

	@Autowired
	OrdinateurDao ordinateurDao;

	@CrossOrigin
	@GetMapping("/ordinateurs")
	public ResponseEntity<List<Ordinateur>> findAll() {
		List<Ordinateur> ordinateurs = ordinateurDao.findAll();
		return new ResponseEntity<List<Ordinateur>>(ordinateurs, HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/ordinateurs/{id}")
	public ResponseEntity<Ordinateur> findOne(@PathVariable("id") Integer id) {
		Ordinateur ordinateur = ordinateurDao.findByPrimaryKey(id);

		if (ordinateur == null) {
			return new ResponseEntity<Ordinateur>(ordinateur, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Ordinateur>(ordinateur, HttpStatus.OK);
		}
	}
	
	@CrossOrigin
	@PostMapping("/ordinateurs")
	public ResponseEntity<Ordinateur> create(@RequestBody Ordinateur ordinateur) {
		if (ordinateur.getId() > 0) {
			return new ResponseEntity<Ordinateur>(HttpStatus.BAD_REQUEST);
		}
		ordinateurDao.save(ordinateur);
		return new ResponseEntity<Ordinateur>(ordinateur, HttpStatus.CREATED);
	}

	@CrossOrigin
	@PutMapping("/ordinateurs")
	public ResponseEntity<Ordinateur> update(@RequestBody Ordinateur ordinateur) {
		if (ordinateur.getId() == 0) {
			return create(ordinateur);
		}
		ordinateur = ordinateurDao.update(ordinateur);

		return new ResponseEntity<Ordinateur>(ordinateur, HttpStatus.OK);
	}

	@CrossOrigin
	@DeleteMapping("/ordinateurs/{id}")
	public ResponseEntity<Ordinateur> delete(@PathVariable("id") Integer id){
		Ordinateur tmp = ordinateurDao.findByPrimaryKey(id);
		if (tmp == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			ordinateurDao.delete(tmp);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}	
	}	

}
