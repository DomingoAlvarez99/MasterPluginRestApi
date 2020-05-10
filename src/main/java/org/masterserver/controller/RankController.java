package org.masterserver.controller;

import java.util.List;

import org.masterserver.model.RankModel;
import org.masterserver.service.RankService;
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
public class RankController {

	@Autowired
	private RankService service;

	@GetMapping("/ranks")
	public ResponseEntity<List<RankModel>> getRanks() {
		return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
	}

	@GetMapping("/rank/{id}")
	public ResponseEntity<RankModel> getRankById(@PathVariable("id") long id) {
		return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
	}
	
	@PostMapping(value = "/rank")
	public ResponseEntity<RankModel> createRank(@RequestBody RankModel rank) {
		return new ResponseEntity<>(service.create(rank), HttpStatus.OK);
	}
	
	@PutMapping("/rank/{id}")
	public ResponseEntity<RankModel> updateRank(@PathVariable("id") long id, @RequestBody RankModel rank) {
		return new ResponseEntity<>(service.update(id, rank), HttpStatus.OK);
	}
	
	@DeleteMapping("/rank/{id}")
	public ResponseEntity<Boolean> deleteRank(@PathVariable("id") long id) {
		return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
	}
	
	@GetMapping("/rank/getByName/{name}")
	public ResponseEntity<RankModel> getByName(@PathVariable("name") String name) {
		return new ResponseEntity<>(service.getByName(name), HttpStatus.OK);
	}

}
