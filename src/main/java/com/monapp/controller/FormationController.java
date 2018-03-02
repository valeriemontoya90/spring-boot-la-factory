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

import com.monapp.dao.FormationDao;
import com.monapp.entity.Formation;

@RestController
@CrossOrigin
public class FormationController {
	
	@Autowired
	FormationDao formationDao;

	@GetMapping("/formations/{id}")
	public ResponseEntity<Formation> findOne(@PathVariable("id") Integer id) {
		Formation formation = formationDao.findByPrimaryKey(id);
		if (formation == null) {
			return new ResponseEntity<Formation>(formation, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Formation>(formation, HttpStatus.OK);
		}
	}

	@GetMapping("/formations")
	public ResponseEntity<List<Formation>> findAll() {
		List<Formation> formations = formationDao.findAll();
		return new ResponseEntity<List<Formation>>(formations, HttpStatus.OK);
	}

	@PostMapping("/formations")
	public ResponseEntity<Formation> create(@RequestBody Formation formation) {
		if (formation.getId() > 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		formationDao.save(formation);
		return new ResponseEntity<Formation>(formation, HttpStatus.CREATED);
	}

	@PutMapping("/formations")
	public ResponseEntity<Formation> update(@RequestBody Formation formation) {
		if (formation.getId() == 0) {
			return create(formation);
		}
		formation = formationDao.update(formation);
		return new ResponseEntity<Formation>(formation, HttpStatus.OK);
	}

	@DeleteMapping("/formations/{id}")
	public ResponseEntity<Formation> delete(@PathVariable("id") Integer id) {
		Formation tmp = formationDao.findByPrimaryKey(id);
		if (tmp == null) {
			formationDao.delete(tmp);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
}