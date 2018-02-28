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

import com.monapp.dao.OrdinateurDao;
import com.monapp.entity.Ordinateur;

@CrossOrigin
@RestController
public class OrdinateurController {

	@Autowired
	OrdinateurDao ordinateurDao;

	@CrossOrigin
	@GetMapping("/ordinateurs")
	public ResponseEntity<List<Ordinateur>> findAll() {
		List<Ordinateur> ordinateur = ordinateurDao.findAll();
		return new ResponseEntity<List<Ordinateur>>(ordinateur, HttpStatus.OK);
	}
	
	@CrossOrigin
	@PostMapping("/ordinateurs")
    public ResponseEntity<Ordinateur> create(@RequestBody Ordinateur ordinateur) {
        if (ordinateur.getId() > 0) {
            return new ResponseEntity<Ordinateur>(ordinateur, HttpStatus.BAD_REQUEST);
        }
        ordinateurDao.save(ordinateur);
        return new ResponseEntity<Ordinateur>(ordinateur, HttpStatus.CREATED);
    }
}
