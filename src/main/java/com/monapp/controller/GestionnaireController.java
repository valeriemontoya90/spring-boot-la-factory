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

import com.fasterxml.jackson.annotation.JsonView;
import com.monapp.dao.GestionnaireDao;
import com.monapp.entity.Gestionnaire;
import com.monapp.entity.Views;

@RestController
@CrossOrigin
public class GestionnaireController {
	@Autowired
	GestionnaireDao gestionnaireDao;

	@GetMapping("/gestionnaires/{id}")
	@JsonView(Views.GestionnaireWithFormation.class)
	public ResponseEntity<Gestionnaire> findOne(@PathVariable("id") Integer id) {
		Gestionnaire gestionnaire = gestionnaireDao.findByPrimaryKey(id);
		if (gestionnaire == null) {
			return new ResponseEntity<Gestionnaire>(gestionnaire, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Gestionnaire>(gestionnaire, HttpStatus.OK);
		}
	}

	@GetMapping("/gestionnaires")
	@JsonView(Views.GestionnaireWithFormation.class)
	public ResponseEntity<List<Gestionnaire>> findAll() {
		List<Gestionnaire> gestionnaires = gestionnaireDao.findAll();
		return new ResponseEntity<List<Gestionnaire>>(gestionnaires, HttpStatus.OK);
	}

	@DeleteMapping("/gestionnaires/{id}")
	public ResponseEntity<Gestionnaire> delete(@PathVariable("id") Integer id) {
		Gestionnaire liv = gestionnaireDao.findByPrimaryKey(id);
		if (liv == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@PostMapping("/gestionnaires")
	@JsonView(Views.GestionnaireWithFormation.class)
	public ResponseEntity<Gestionnaire> create(@RequestBody Gestionnaire gestionnaire) {
		if (gestionnaire.getId() > 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		gestionnaireDao.save(gestionnaire);
		return new ResponseEntity<Gestionnaire>(gestionnaire, HttpStatus.CREATED);
	}

	@PutMapping("/gestionnaires")
	@JsonView(Views.GestionnaireWithFormation.class)
	public ResponseEntity<Gestionnaire> update(@RequestBody Gestionnaire gestionnaire) {
		if (gestionnaire.getId() == 0) {
			return create(gestionnaire);
		}
		gestionnaire = gestionnaireDao.update(gestionnaire);
		return new ResponseEntity<Gestionnaire>(gestionnaire, HttpStatus.OK);
	}

}