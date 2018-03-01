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

import com.monapp.dao.TechnicienDao;
import com.monapp.entity.Technicien;

@RestController
@CrossOrigin
public class TechnicienController {
	@Autowired
	TechnicienDao technicienDao;

	@GetMapping("/techniciens/{id}")
	public ResponseEntity<Technicien> findOne(@PathVariable("id") Integer id) {
		Technicien technicien = technicienDao.findByPrimaryKey(id);
		if (technicien == null) {
			return new ResponseEntity<Technicien>(technicien, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Technicien>(technicien, HttpStatus.OK);
		}
	}

	@GetMapping("/techniciens")
	public ResponseEntity<List<Technicien>> findAll() {
		List<Technicien> techniciens = technicienDao.findAll();
		return new ResponseEntity<List<Technicien>>(techniciens, HttpStatus.OK);
	}

	@PostMapping("/techniciens")
	public ResponseEntity<Technicien> create(@RequestBody Technicien technicien) {
		if (technicien.getId() > 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		technicienDao.save(technicien);
		return new ResponseEntity<Technicien>(technicien, HttpStatus.CREATED);
	}

	@PutMapping("/techniciens")
	public ResponseEntity<Technicien> update(@RequestBody Technicien technicien) {
		if (technicien.getId() == 0) {
			return create(technicien);
		}
		technicien = technicienDao.update(technicien);
		return new ResponseEntity<Technicien>(technicien, HttpStatus.OK);
	}

	@DeleteMapping("/techniciens/{id}")
	public ResponseEntity<Technicien> delete(@PathVariable("id") Integer id) {
		Technicien tmp = technicienDao.findByPrimaryKey(id);
		if (tmp == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			technicienDao.delete(tmp);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

}
