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

import com.monapp.dao.CursusDeFormationDao;
import com.monapp.entity.CursusDeFormation;
import com.monapp.entity.Formation;

@RestController
@CrossOrigin
public class CursusDeFormationController {
	
	@Autowired
	CursusDeFormationDao cursusDeFormationDao;

	@GetMapping("/cursus/{id}")
	public ResponseEntity<CursusDeFormation> findOne(@PathVariable("id") Integer id) {
		CursusDeFormation cursus = cursusDeFormationDao.findByPrimaryKey(id);
		if (cursus == null) {
			return new ResponseEntity<CursusDeFormation>(cursus, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<CursusDeFormation>(cursus, HttpStatus.OK);
		}
	}

	@GetMapping("/cursus")
	public ResponseEntity<List<CursusDeFormation>> findAll() {
		List<CursusDeFormation> cursus = cursusDeFormationDao.findAll();
		return new ResponseEntity<List<CursusDeFormation>>(cursus, HttpStatus.OK);
	}

	@PostMapping("/cursus")
	public ResponseEntity<CursusDeFormation> create(@RequestBody CursusDeFormation cursus) {
		if (cursus.getId() > 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		cursusDeFormationDao.save(cursus);
		return new ResponseEntity<CursusDeFormation>(cursus, HttpStatus.CREATED);
	}

	@PutMapping("/cursus")
	public ResponseEntity<CursusDeFormation> update(@RequestBody CursusDeFormation cursus) {
		if (cursus.getId() == 0) {
			return create(cursus);
		}
		cursus = cursusDeFormationDao.update(cursus);
		return new ResponseEntity<CursusDeFormation>(cursus, HttpStatus.OK);
	}

	@DeleteMapping("/cursus/{id}")
	public ResponseEntity<CursusDeFormation> delete(@PathVariable("id") Integer id) {
		CursusDeFormation tmp = cursusDeFormationDao.findByPrimaryKey(id);
		if (tmp == null) {
			cursusDeFormationDao.delete(tmp);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
}