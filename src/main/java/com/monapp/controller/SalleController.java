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

import com.monapp.dao.SalleDao;
import com.monapp.entity.Salle;

@CrossOrigin
@RestController
public class SalleController {

	@Autowired
	SalleDao salleDao;

	@CrossOrigin
	@GetMapping("/salles")
	public ResponseEntity<List<Salle>> findAll() {
		List<Salle> salle = salleDao.findAll();
		return new ResponseEntity<List<Salle>>(salle, HttpStatus.OK);
	}
	
	@PostMapping("/salles")
    public ResponseEntity<Salle> create(@RequestBody Salle salle) {
        if (salle.getId() > 0) {
            return new ResponseEntity<Salle>(salle, HttpStatus.BAD_REQUEST);
        }
        salleDao.save(salle);
        return new ResponseEntity<Salle>(salle, HttpStatus.CREATED);
    }	
	
}
