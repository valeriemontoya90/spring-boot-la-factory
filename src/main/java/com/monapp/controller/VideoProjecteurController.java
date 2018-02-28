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

import com.monapp.dao.VideoProjecteurDao;
import com.monapp.entity.VideoProjecteur;

@CrossOrigin
@RestController
public class VideoProjecteurController {

	@Autowired
	VideoProjecteurDao videoProjecteurDao;

	@CrossOrigin
	@GetMapping("/videos")
	public ResponseEntity<List<VideoProjecteur>> findAll() {
		List<VideoProjecteur> videoProjecteur = videoProjecteurDao.findAll();
		return new ResponseEntity<List<VideoProjecteur>>(videoProjecteur, HttpStatus.OK);
	}
	
	@PostMapping("/videos")
    public ResponseEntity<VideoProjecteur> create(@RequestBody VideoProjecteur videoProjecteur) {
        if (videoProjecteur.getId() > 0) {
            return new ResponseEntity<VideoProjecteur>(videoProjecteur, HttpStatus.BAD_REQUEST);
        }
        videoProjecteurDao.save(videoProjecteur);
        return new ResponseEntity<VideoProjecteur>(videoProjecteur, HttpStatus.CREATED);
    }	
	
}
