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

import com.monapp.dao.MatiereDao;
import com.monapp.entity.Matiere;

@CrossOrigin
@RestController
public class MatiereController {

    @Autowired
    MatiereDao matiereDao;

    @CrossOrigin
    @GetMapping("/matieres")
    public ResponseEntity<List<Matiere>> findAll() {
        List<Matiere> matiere = matiereDao.findAll();
        return new ResponseEntity<List<Matiere>>(matiere, HttpStatus.OK);
    }
    
    @CrossOrigin
    @GetMapping("/matieres/{id}")
    public ResponseEntity<Matiere> findOne(@PathVariable("id") Integer id) {
        Matiere matiere = matiereDao.findByPrimaryKey(id);

        if (matiere == null) {
            return new ResponseEntity<Matiere>(matiere, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Matiere>(matiere, HttpStatus.OK);
        }
    }
    
    @CrossOrigin
    @PostMapping("/matieres")
    public ResponseEntity<Matiere> create(@RequestBody Matiere matiere) {
        if (matiere.getId() > 0) {
            return new ResponseEntity<Matiere>(matiere, HttpStatus.BAD_REQUEST);
        }
        matiereDao.save(matiere);
        return new ResponseEntity<Matiere>(matiere, HttpStatus.CREATED);
    }

    @CrossOrigin
    @PutMapping("/matieres")
    public ResponseEntity<Matiere> update(@RequestBody Matiere matiere) {
        if (matiere.getId() == 0) {
            return create(matiere);
        }
        matiere = matiereDao.update(matiere);

        return new ResponseEntity<Matiere>(matiere, HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping("/matieres/{id}")
    public ResponseEntity<Matiere> delete(@PathVariable("id") Integer id){
        Matiere tmp = matiereDao.findByPrimaryKey(id);
        if (tmp == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            matiereDao.delete(tmp);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }    
    }    

}