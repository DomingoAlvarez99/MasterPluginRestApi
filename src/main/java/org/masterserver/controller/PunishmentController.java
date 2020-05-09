package org.masterserver.controller;

import java.util.Calendar;
import java.util.List;

import org.masterserver.model.PunishmentModel;
import org.masterserver.service.PunishmentService;
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
public class PunishmentController {

	@Autowired
	private PunishmentService service;

	@GetMapping("/punishments")
	public ResponseEntity<List<PunishmentModel>> getPunishments() {
		return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
	}

	@GetMapping("/punishment/{id}")
	public ResponseEntity<PunishmentModel> getPunishmentById(@PathVariable("id") long id) {
		return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
	}
	
	@PostMapping(value = "/punishment")
	public ResponseEntity<PunishmentModel> createPunishment(@RequestBody PunishmentModel punishment) {
		return new ResponseEntity<>(service.create(punishment), HttpStatus.OK);
	}
	
	@PutMapping("/punishment/{id}")
	public ResponseEntity<PunishmentModel> updatePunishment(@PathVariable("id") long id, @RequestBody PunishmentModel punishment) {
		return new ResponseEntity<>(service.update(id, punishment), HttpStatus.OK);
	}
	
	@DeleteMapping("/punishment/{id}")
	public ResponseEntity<Boolean> deletePunishment(@PathVariable("id") long id) {
		return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
	}
	
	@GetMapping("/punishments/getByDate/{date}")
	public ResponseEntity<List<PunishmentModel>> getByDate(@PathVariable("date") Calendar date) {
		return new ResponseEntity<>(service.getByDate(date), HttpStatus.OK);
	}
	
	@GetMapping("/punishments/getByDescription/{description}")
	public ResponseEntity<List<PunishmentModel>> getByDescription(@PathVariable("description") String description) {
		return new ResponseEntity<>(service.getByDescription(description), HttpStatus.OK);
	}
	
	@GetMapping("/punishments/getByType/{type}")
	public ResponseEntity<List<PunishmentModel>> getByType(@PathVariable("type") String type) {
		return new ResponseEntity<>(service.getByType(type), HttpStatus.OK);
	}

}
