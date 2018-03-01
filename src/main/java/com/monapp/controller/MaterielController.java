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

import com.monapp.dao.MaterielDao;
import com.monapp.entity.Materiel;

@CrossOrigin
@RestController
public class MaterielController {

	@Autowired
	MaterielDao materielDao;

	@CrossOrigin
	@GetMapping("/materiels")
	public ResponseEntity<List<Materiel>> findAll() {
		List<Materiel> materiel = materielDao.findAll();
		return new ResponseEntity<List<Materiel>>(materiel, HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/materiels/{id}")
	public ResponseEntity<Materiel> findOne(@PathVariable("id") Integer id) {
		Materiel materiel = materielDao.findByPrimaryKey(id);

		if (materiel == null) {
			return new ResponseEntity<Materiel>(materiel, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Materiel>(materiel, HttpStatus.OK);
		}
	}
	
	@CrossOrigin
	@PostMapping("/materiels")
	public ResponseEntity<Materiel> create(@RequestBody Materiel materiel) {
		if (materiel.getId() > 0) {
			return new ResponseEntity<Materiel>(materiel, HttpStatus.BAD_REQUEST);
		}
		materielDao.save(materiel);
		return new ResponseEntity<Materiel>(materiel, HttpStatus.CREATED);
	}

	@CrossOrigin
	@PutMapping("/materiels")
	public ResponseEntity<Materiel> update(@RequestBody Materiel materiel) {
		if (materiel.getId() == 0) {
			return create(materiel);
		}
		materiel = materielDao.update(materiel);

		return new ResponseEntity<Materiel>(materiel, HttpStatus.OK);
	}

	@CrossOrigin
	@DeleteMapping("/materiels/{id}")
	public ResponseEntity<Materiel> delete(@PathVariable("id") Integer id){
		Materiel tmp = materielDao.findByPrimaryKey(id);
		if (tmp == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			materielDao.delete(tmp);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}	
	}	

}
