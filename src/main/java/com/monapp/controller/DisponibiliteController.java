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

import com.monapp.dao.DisponibiliteDao;
import com.monapp.entity.Disponibilite;

@RestController
@CrossOrigin
public class DisponibiliteController {
	@Autowired
	DisponibiliteDao disponibiliteDao;

	@GetMapping("/disponibilites/{id}")
	public ResponseEntity<Disponibilite> findOne(@PathVariable("id") Integer id) {
		Disponibilite disponibilite = disponibiliteDao.findByPrimaryKey(id);
		if (disponibilite == null) {
			return new ResponseEntity<Disponibilite>(disponibilite, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Disponibilite>(disponibilite, HttpStatus.OK);
		}
	}

	@GetMapping("/disponibilites")
	public ResponseEntity<List<Disponibilite>> findAll() {
		List<Disponibilite> disponibilites = disponibiliteDao.findAll();
		return new ResponseEntity<List<Disponibilite>>(disponibilites, HttpStatus.OK);
	}

	@DeleteMapping("/disponibilites/{id}")
	public ResponseEntity<Disponibilite> delete(@PathVariable("id") Integer id) {
		Disponibilite liv = disponibiliteDao.findByPrimaryKey(id);
		if (liv == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@PostMapping("/disponibilites")
	public ResponseEntity<Disponibilite> create(@RequestBody Disponibilite disponibilite) {
		if (disponibilite.getId() > 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		disponibiliteDao.save(disponibilite);
		return new ResponseEntity<Disponibilite>(disponibilite, HttpStatus.CREATED);
	}

	@PutMapping("/disponibilites")
	public ResponseEntity<Disponibilite> update(@RequestBody Disponibilite disponibilite) {
		if (disponibilite.getId() == 0) {
			return create(disponibilite);
		}
		disponibilite = disponibiliteDao.update(disponibilite);
		return new ResponseEntity<Disponibilite>(disponibilite, HttpStatus.OK);
	}

}
