package org.masterserver.controller;

import java.util.List;

import org.masterserver.model.CommandModel;
import org.masterserver.service.CommandService;
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
public class CommandController {

	@Autowired
	private CommandService service;

	@GetMapping("/commands")
	public ResponseEntity<List<CommandModel>> getCommands() {
		return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
	}

	@GetMapping("/command/{id}")
	public ResponseEntity<CommandModel> getCommandById(@PathVariable("id") long id) {
		return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
	}
	
	@PostMapping(value = "/command")
	public ResponseEntity<CommandModel> createCommand(@RequestBody CommandModel command) {
		return new ResponseEntity<>(service.create(command), HttpStatus.OK);
	}
	
	@PutMapping("/command/{id}")
	public ResponseEntity<CommandModel> updateCommand(@PathVariable("id") long id, @RequestBody CommandModel command) {
		return new ResponseEntity<>(service.update(id, command), HttpStatus.OK);
	}
	
	@DeleteMapping("/command/{id}")
	public ResponseEntity<Boolean> deleteCommand(@PathVariable("id") long id) {
		return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
	}
	
	@GetMapping("/commands/getByCommand/{command}")
	public ResponseEntity<List<CommandModel>> getByCommand(@PathVariable("command") String command) {
		return new ResponseEntity<>(service.getByCommand(command), HttpStatus.OK);
	}

}
