package org.masterserver.controller;

import java.util.List;

import org.masterserver.model.ItemModel;
import org.masterserver.service.ItemService;
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
public class ItemController {

	@Autowired
	private ItemService service;

	@GetMapping("/items")
	public ResponseEntity<List<ItemModel>> getItems() {
		return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
	}

	@GetMapping("/item/{id}")
	public ResponseEntity<ItemModel> getItemById(@PathVariable("id") long id) {
		return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
	}
	
	@PostMapping(value = "/item")
	public ResponseEntity<ItemModel> createItem(@RequestBody ItemModel item) {
		return new ResponseEntity<>(service.create(item), HttpStatus.OK);
	}
	
	@PutMapping("/item/{id}")
	public ResponseEntity<ItemModel> updateItem(@PathVariable("id") long id, @RequestBody ItemModel item) {
		return new ResponseEntity<>(service.update(id, item), HttpStatus.OK);
	}
	
	@DeleteMapping("/item/{id}")
	public ResponseEntity<Boolean> deleteItem(@PathVariable("id") long id) {
		return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
	}
	
	@GetMapping("/items/getByDurability/{durability}")
	public ResponseEntity<List<ItemModel>> getByDurability(@PathVariable("durability") long durability) {
		return new ResponseEntity<>(service.getByDurability(durability), HttpStatus.OK);
	}
	
	@GetMapping("/item/getByName/{name}")
	public ResponseEntity<ItemModel> getByName(@PathVariable("name") String name) {
		return new ResponseEntity<>(service.getByName(name), HttpStatus.OK);
	}
	
	@GetMapping("/items/getByType/{type}")
	public ResponseEntity<List<ItemModel>> getByType(@PathVariable("type") String type) {
		return new ResponseEntity<>(service.getByType(type), HttpStatus.OK);
	}
	
	@GetMapping("/item/getByUuid/{uuid}")
	public ResponseEntity<ItemModel> getByUuid(@PathVariable("uuid") long uuid) {
		return new ResponseEntity<>(service.getByUuid(uuid), HttpStatus.OK);
	}

}
