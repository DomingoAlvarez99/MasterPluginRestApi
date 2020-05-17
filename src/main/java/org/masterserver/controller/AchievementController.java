package org.masterserver.controller;

import java.util.List;

import org.masterserver.model.AchievementModel;
import org.masterserver.service.AchievementService;
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
public class AchievementController {

	@Autowired
	private AchievementService service;

	@GetMapping("/achievements")
	public ResponseEntity<List<AchievementModel>> getAchievements() {
		return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
	}

	@GetMapping("/achievement/{id}")
	public ResponseEntity<AchievementModel> getAchievementById(@PathVariable("id") long id) {
		return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
	}
	
	@PostMapping(value = "/achievement")
	public ResponseEntity<AchievementModel> createAchievement(@RequestBody AchievementModel achievement) {
		return new ResponseEntity<>(service.create(achievement), HttpStatus.OK);
	}
	
	@PutMapping("/achievement/{id}")
	public ResponseEntity<AchievementModel> updateAchievement(@PathVariable("id") long id, @RequestBody AchievementModel achievement) {
		return new ResponseEntity<>(service.update(id, achievement), HttpStatus.OK);
	}
	
	@DeleteMapping("/achievement/{id}")
	public ResponseEntity<Boolean> deleteAchievement(@PathVariable("id") long id) {
		return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
	}
	
	@GetMapping("/achievements/getByName/{name}")
	public ResponseEntity<List<AchievementModel>> getByName(@PathVariable("name") String name) {
		return new ResponseEntity<>(service.getByName(name), HttpStatus.OK);
	}

}
