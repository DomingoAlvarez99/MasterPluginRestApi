package org.masterserver.controller;

import java.util.List;

import org.masterserver.model.PlayerModel;
import org.masterserver.service.PlayerService;
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
public class PlayerController {

	@Autowired
	private PlayerService service;

	@GetMapping("/players")
	public ResponseEntity<List<PlayerModel>> getPlayers() {
		return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
	}

	@GetMapping("/player/{id}")
	public ResponseEntity<PlayerModel> getPlayerById(@PathVariable("id") long id) {
		return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
	}

	@PostMapping(value = "/player")
	public ResponseEntity<PlayerModel> createPlayer(@RequestBody PlayerModel player) {
		return new ResponseEntity<>(service.create(player), HttpStatus.OK);
	}

	@PutMapping("/player/{id}")
	public ResponseEntity<PlayerModel> updatePlayer(@PathVariable("id") long id, @RequestBody PlayerModel player) {
		return new ResponseEntity<>(service.update(id, player), HttpStatus.OK);
	}

	@DeleteMapping("/player/{id}")
	public ResponseEntity<Boolean> deletePlayer(@PathVariable("id") long id) {
		return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
	}

	@GetMapping("/player/getByName/{name}")
	public ResponseEntity<PlayerModel> getByName(@PathVariable("name") String name) {
		return new ResponseEntity<>(service.getByName(name), HttpStatus.OK);
	}

	@GetMapping("/player/getByUuid/{uuid}")
	public ResponseEntity<PlayerModel> getByUuid(@PathVariable("uuid") String uuid) {
		return new ResponseEntity<>(service.getByUuid(uuid), HttpStatus.OK);
	}

	@GetMapping("/players/getByNameColor/{nameColor}")
	public ResponseEntity<List<PlayerModel>> getByNameColor(@PathVariable("nameColor") String nameColor) {
		return new ResponseEntity<>(service.getByNameColor(nameColor), HttpStatus.OK);
	}

	@GetMapping("/players/getByNameFormat/{nameFormat}")
	public ResponseEntity<List<PlayerModel>> getByNameFormat(@PathVariable("nameFormat") String nameFormat) {
		return new ResponseEntity<>(service.getByNameFormat(nameFormat), HttpStatus.OK);
	}

	@GetMapping("/players/getByPrefix/{prefix}")
	public ResponseEntity<List<PlayerModel>> getByPrefix(@PathVariable("prefix") String prefix) {
		return new ResponseEntity<>(service.getByPrefix(prefix), HttpStatus.OK);
	}

	@GetMapping("/players/getByPrefixColor/{prefixColor}")
	public ResponseEntity<List<PlayerModel>> getByPrefixColor(@PathVariable("prefixColor") String prefixColor) {
		return new ResponseEntity<>(service.getByPrefixColor(prefixColor), HttpStatus.OK);
	}

	@GetMapping("/players/getByPrefixFormat/{prefixFormat}")
	public ResponseEntity<List<PlayerModel>> getByPrefixFormat(@PathVariable("prefixFormat") String prefixFormat) {
		return new ResponseEntity<>(service.getByPrefixFormat(prefixFormat), HttpStatus.OK);
	}

	@GetMapping("/players/getByTimePlayed/{timePlayed}")
	public ResponseEntity<List<PlayerModel>> getByTimePlayed(@PathVariable("timePlayed") long timePlayed) {
		return new ResponseEntity<>(service.getByTimePlayed(timePlayed), HttpStatus.OK);
	}

}
