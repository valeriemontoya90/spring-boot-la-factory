package com.monapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
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
	@PostMapping("/materiels")
    public ResponseEntity<Materiel> create(@RequestBody Materiel materiel) {
        if (materiel.getId() > 0) {
            return new ResponseEntity<Materiel>(materiel, HttpStatus.BAD_REQUEST);
        }
        materielDao.save(materiel);
        return new ResponseEntity<Materiel>(materiel, HttpStatus.CREATED);
    }
	
}
