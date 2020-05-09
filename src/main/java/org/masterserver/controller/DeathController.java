package org.masterserver.controller;

import java.util.List;

import org.masterserver.model.DeathModel;
import org.masterserver.service.DeathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeathController {

	@Autowired
	private DeathService service;

	@GetMapping("/deaths")
	public ResponseEntity<List<DeathModel>> getDeaths() {
		return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
	}

	@GetMapping("/death/{id}")
	public ResponseEntity<DeathModel> getDeathById(@PathVariable("id") long id) {
		return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
	}
	
	@PostMapping(value = "/death")
	public ResponseEntity<DeathModel> createDeath(@RequestBody DeathModel death) {
		return new ResponseEntity<>(service.create(death), HttpStatus.OK);
	}
	
	@PutMapping("/death/{id}")
	public ResponseEntity<DeathModel> updateDeath(@PathVariable("id") long id, @RequestBody DeathModel death) {
		return new ResponseEntity<>(service.update(id, death), HttpStatus.OK);
	}
	
	@DeleteMapping("/death/{id}")
	public ResponseEntity<Boolean> deleteDeath(@PathVariable("id") long id) {
		return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
	}
	
	@GetMapping("/deaths/getByCause/{cause}")
	public ResponseEntity<List<DeathModel>> getByCause(@PathVariable("cause") String cause) {
		return new ResponseEntity<>(service.getByCause(cause), HttpStatus.OK);
	}

}
