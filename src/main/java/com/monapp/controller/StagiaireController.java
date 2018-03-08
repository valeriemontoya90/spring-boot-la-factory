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
import com.monapp.dao.StagiaireDao;
import com.monapp.entity.Ordinateur;
import com.monapp.entity.Stagiaire;

@RestController
@CrossOrigin
public class StagiaireController {
	
	@Autowired
	StagiaireDao stagiaireDao;

	@Autowired
	OrdinateurDao ordinateurDao;
	
	@CrossOrigin
	@GetMapping("/stagiaires/{id}")
	public ResponseEntity<Stagiaire> findOne(@PathVariable("id") Integer id) {
		Stagiaire stagiaire = stagiaireDao.findByPrimaryKey(id);
		if (stagiaire == null) {
			return new ResponseEntity<Stagiaire>(stagiaire, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Stagiaire>(stagiaire, HttpStatus.OK);
		}
	}
	
	@CrossOrigin
	@GetMapping("/stagiaires")
	public ResponseEntity<List<Stagiaire>> findAll() {
		List<Stagiaire> stagiaires = stagiaireDao.findAll();
		return new ResponseEntity<List<Stagiaire>>(stagiaires, HttpStatus.OK);
	}
	
	@CrossOrigin
	@PostMapping("/stagiaires")
	public ResponseEntity<Stagiaire> create(@RequestBody Stagiaire stagiaire) {
		if (stagiaire.getId() > 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		stagiaireDao.save(stagiaire);
		if(stagiaire.getOrdinateur() != null) {
			Ordinateur ordinateurFound = ordinateurDao.findByPrimaryKey(stagiaire.getOrdinateur().getId());
			ordinateurFound.setIsDisponible(false);
			ordinateurDao.update(ordinateurFound);
		}
		return new ResponseEntity<Stagiaire>(stagiaire, HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@PutMapping("/stagiaires")
	public ResponseEntity<Stagiaire> update(@RequestBody Stagiaire stagiaire) {
		if (stagiaire.getId() == 0) {
			return create(stagiaire);
		}
		stagiaire = stagiaireDao.update(stagiaire);
		return new ResponseEntity<Stagiaire>(stagiaire, HttpStatus.OK);
	}
	
	@CrossOrigin
	@DeleteMapping("/stagiaires/{id}")
	public ResponseEntity<Stagiaire> delete(@PathVariable("id") Integer id) {
		Stagiaire tmp = stagiaireDao.findByPrimaryKey(id);
		if (tmp == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			stagiaireDao.delete(tmp);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

}
