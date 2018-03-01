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

import com.monapp.dao.FormateurDao;
import com.monapp.entity.Formateur;

@RestController
@CrossOrigin
public class FormateurController {

	@Autowired
	FormateurDao formateurDao;

	@CrossOrigin
	@GetMapping("/formateurs")
	public ResponseEntity<List<Formateur>> findAll() {
		List<Formateur> formateurs = formateurDao.findAll();
		return new ResponseEntity<List<Formateur>>(formateurs, HttpStatus.OK);
	}

	@CrossOrigin
	@GetMapping("/formateurs/{id}")
	public ResponseEntity<Formateur> findOne(@PathVariable("id") Integer id) {
		Formateur formateur = formateurDao.findByPrimaryKey(id);
		if (formateur == null) {
			return new ResponseEntity<Formateur>(formateur, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Formateur>(formateur, HttpStatus.OK);
		}
	}

	@CrossOrigin
	@PostMapping("/formateurs")
	public ResponseEntity<Formateur> create(@RequestBody Formateur formateur) {
		if (formateur.getId() > 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		formateurDao.save(formateur);
		return new ResponseEntity<Formateur>(formateur, HttpStatus.CREATED);
	}

	@CrossOrigin
	@PutMapping("/formateurs")
	public ResponseEntity<Formateur> update(@RequestBody Formateur formateur) {
		if (formateur.getId() == 0) {
			return create(formateur);
		}
		formateur = formateurDao.update(formateur);
		return new ResponseEntity<Formateur>(formateur, HttpStatus.OK);
	}

	@CrossOrigin
	@DeleteMapping("/formateurs/{id}")
	public ResponseEntity<Formateur> delete(@PathVariable("id") Integer id) {
		Formateur tmp = formateurDao.findByPrimaryKey(id);
		if (tmp == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			formateurDao.delete(tmp);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

}
