package org.masterserver.controller;

import java.util.List;

import org.masterserver.model.WarpModel;
import org.masterserver.service.WarpService;
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
public class WarpController {

	@Autowired
	private WarpService service;

	@GetMapping("/warps")
	public ResponseEntity<List<WarpModel>> getWarps() {
		return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
	}

	@GetMapping("/warp/{id}")
	public ResponseEntity<WarpModel> getWarpById(@PathVariable("id") long id) {
		return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
	}
	
	@PostMapping(value = "/warp")
	public ResponseEntity<WarpModel> createWarp(@RequestBody WarpModel warp) {
		return new ResponseEntity<>(service.create(warp), HttpStatus.OK);
	}
	
	@PutMapping("/warp/{id}")
	public ResponseEntity<WarpModel> updateWarp(@PathVariable("id") long id, @RequestBody WarpModel warp) {
		return new ResponseEntity<>(service.update(id, warp), HttpStatus.OK);
	}
	
	@DeleteMapping("/warp/{id}")
	public ResponseEntity<Boolean> deleteWarp(@PathVariable("id") long id) {
		return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
	}
	
	@GetMapping("/warps/getByName/{name}")
	public ResponseEntity<List<WarpModel>> getByName(@PathVariable("playerId") String name) {
		return new ResponseEntity<>(service.getByName(name), HttpStatus.OK);
	}
	
	@GetMapping("/warps/getByCoordinateX/{coordinateX}")
	public ResponseEntity<List<WarpModel>> getByCoordinateX(@PathVariable("coordinateX") long coordinateX) {
		return new ResponseEntity<>(service.getByCoordinateX(coordinateX), HttpStatus.OK);
	}
	
	@GetMapping("/warps/getByCoordinateY/{coordinateY}")
	public ResponseEntity<List<WarpModel>> getByCoordinateY(@PathVariable("coordinateY") long coordinateY) {
		return new ResponseEntity<>(service.getByCoordinateX(coordinateY), HttpStatus.OK);
	}
	
	@GetMapping("/warps/getByCoordinateZ/{coordinateZ}")
	public ResponseEntity<List<WarpModel>> getByCoordinateZ(@PathVariable("coordinateZ") long coordinateZ) {
		return new ResponseEntity<>(service.getByCoordinateX(coordinateZ), HttpStatus.OK);
	}
	
	@GetMapping("/warps/getByPlayerId/{playerId}")
	public ResponseEntity<List<WarpModel>> getByPlayerId(@PathVariable("playerId") long playerId) {
		return new ResponseEntity<>(service.getByPlayerId(playerId), HttpStatus.OK);
	}

}
