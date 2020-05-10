package org.masterserver.controller;

import java.util.List;

import org.masterserver.model.PermissionModel;
import org.masterserver.service.PermissionService;
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
public class PermissionController {

	@Autowired
	private PermissionService service;

	@GetMapping("/permissions")
	public ResponseEntity<List<PermissionModel>> getPermissions() {
		return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
	}

	@GetMapping("/permission/{id}")
	public ResponseEntity<PermissionModel> getPermissionById(@PathVariable("id") long id) {
		return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
	}
	
	@PostMapping(value = "/permission")
	public ResponseEntity<PermissionModel> createPermission(@RequestBody PermissionModel permission) {
		return new ResponseEntity<>(service.create(permission), HttpStatus.OK);
	}
	
	@PutMapping("/permission/{id}")
	public ResponseEntity<PermissionModel> updatePermission(@PathVariable("id") long id, @RequestBody PermissionModel permission) {
		return new ResponseEntity<>(service.update(id, permission), HttpStatus.OK);
	}
	
	@DeleteMapping("/permission/{id}")
	public ResponseEntity<Boolean> deletePermission(@PathVariable("id") long id) {
		return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
	}
	
	@GetMapping("/permission/getByName/{name}")
	public ResponseEntity<PermissionModel> getByName(@PathVariable("name") String name) {
		return new ResponseEntity<>(service.getByName(name), HttpStatus.OK);
	}

}
