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

import com.monapp.dao.SalleDao;
import com.monapp.entity.Salle;

@CrossOrigin
@RestController
public class SalleController {

	@Autowired
	SalleDao salleDao;

	@CrossOrigin
	@GetMapping("/salles")
	public ResponseEntity<List<Salle>> findAll() {
		List<Salle> salle = salleDao.findAll();
		return new ResponseEntity<List<Salle>>(salle, HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/salles/{id}")
	public ResponseEntity<Salle> findOne(@PathVariable("id") Integer id) {
		Salle salle = salleDao.findByPrimaryKey(id);

		if (salle == null) {
			return new ResponseEntity<Salle>(salle, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Salle>(salle, HttpStatus.OK);
		}
	}
	
	@CrossOrigin
	@PostMapping("/salles")
	public ResponseEntity<Salle> create(@RequestBody Salle salle) {
		if (salle.getId() > 0) {
			return new ResponseEntity<Salle>(salle, HttpStatus.BAD_REQUEST);
		}
		salleDao.save(salle);
		return new ResponseEntity<Salle>(salle, HttpStatus.CREATED);
	}

	@CrossOrigin
	@PutMapping("/salles")
	public ResponseEntity<Salle> update(@RequestBody Salle salle) {
		if (salle.getId() == 0) {
			return create(salle);
		}
		salle = salleDao.update(salle);

		return new ResponseEntity<Salle>(salle, HttpStatus.OK);
	}

	@CrossOrigin
	@DeleteMapping("/salles/{id}")
	public ResponseEntity<Salle> delete(@PathVariable("id") Integer id){
		Salle tmp = salleDao.findByPrimaryKey(id);
		if (tmp == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			salleDao.delete(tmp);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}	
	}	

}
