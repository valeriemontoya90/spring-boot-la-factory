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

import com.monapp.dao.CompetenceDao;
import com.monapp.entity.Competence;

@RestController
@CrossOrigin
public class CompetenceController {
	@Autowired
	CompetenceDao competenceDao;

	@GetMapping("/competences/{id}")
	public ResponseEntity<Competence> findOne(@PathVariable("id") Integer id) {
		Competence competence = competenceDao.findByPrimaryKey(id);
		if (competence == null) {
			return new ResponseEntity<Competence>(competence, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Competence>(competence, HttpStatus.OK);
		}
	}

	@GetMapping("/competences")
	public ResponseEntity<List<Competence>> findAll() {
		List<Competence> competences = competenceDao.findAll();
		return new ResponseEntity<List<Competence>>(competences, HttpStatus.OK);
	}

	@DeleteMapping("/competences/{id}")
	public ResponseEntity<Competence> delete(@PathVariable("id") Integer id) {
		Competence liv = competenceDao.findByPrimaryKey(id);
		if (liv == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@PostMapping("/competences")
	public ResponseEntity<Competence> create(@RequestBody Competence competence) {
		if (competence.getId() > 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		competenceDao.save(competence);
		return new ResponseEntity<Competence>(competence, HttpStatus.CREATED);
	}

	@PutMapping("/competences")
	public ResponseEntity<Competence> update(@RequestBody Competence competence) {
		if (competence.getId() == 0) {
			return create(competence);
		}
		competence = competenceDao.update(competence);
		return new ResponseEntity<Competence>(competence, HttpStatus.OK);
	}
}