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

import com.monapp.dao.VideoProjecteurDao;
import com.monapp.entity.VideoProjecteur;

@CrossOrigin
@RestController
public class VideoProjecteurController {

	@Autowired
	VideoProjecteurDao videoProjecteurDao;

	@CrossOrigin
	@GetMapping("/videoProjecteurs")
	public ResponseEntity<List<VideoProjecteur>> findAll() {
		List<VideoProjecteur> videoProjecteur = videoProjecteurDao.findAll();
		return new ResponseEntity<List<VideoProjecteur>>(videoProjecteur, HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/videoProjecteurs/{id}")
	public ResponseEntity<VideoProjecteur> findOne(@PathVariable("id") Integer id) {
		VideoProjecteur videoProjecteur = videoProjecteurDao.findByPrimaryKey(id);

		if (videoProjecteur == null) {
			return new ResponseEntity<VideoProjecteur>(videoProjecteur, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<VideoProjecteur>(videoProjecteur, HttpStatus.OK);
		}
	}
	
	@CrossOrigin
	@PostMapping("/videoProjecteurs")
	public ResponseEntity<VideoProjecteur> create(@RequestBody VideoProjecteur videoProjecteur) {
		if (videoProjecteur.getId() > 0) {
			return new ResponseEntity<VideoProjecteur>(videoProjecteur, HttpStatus.BAD_REQUEST);
		}
		videoProjecteurDao.save(videoProjecteur);
		return new ResponseEntity<VideoProjecteur>(videoProjecteur, HttpStatus.CREATED);
	}

	@CrossOrigin
	@PutMapping("/videoProjecteurs")
	public ResponseEntity<VideoProjecteur> update(@RequestBody VideoProjecteur videoProjecteur) {
		if (videoProjecteur.getId() == 0) {
			return create(videoProjecteur);
		}
		videoProjecteur = videoProjecteurDao.update(videoProjecteur);

		return new ResponseEntity<VideoProjecteur>(videoProjecteur, HttpStatus.OK);
	}

	@CrossOrigin
	@DeleteMapping("/videoProjecteurs/{id}")
	public ResponseEntity<VideoProjecteur> delete(@PathVariable("id") Integer id){
		VideoProjecteur tmp = videoProjecteurDao.findByPrimaryKey(id);
		if (tmp == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			videoProjecteurDao.delete(tmp);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}	
	}	

}
