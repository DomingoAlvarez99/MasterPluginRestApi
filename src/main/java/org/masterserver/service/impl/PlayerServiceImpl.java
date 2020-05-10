package org.masterserver.service.impl;

import java.util.List;

import org.masterserver.model.PlayerModel;
import org.masterserver.repository.PlayerRepository;
import org.masterserver.service.PlayerService;
import org.masterserver.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	private PlayerRepository repository;

	@Override
	public List<PlayerModel> getAll() {
		List<PlayerModel> players = repository.findAll();
		if (players.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Players not found.");
		}
		return repository.findAll();
	}

	@Override
	public PlayerModel getById(long id) {
		return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Id {" + id + "} not found, couldn't get player."));
	}

	@Override
	public PlayerModel create(PlayerModel player) {
		if (repository.findByName(player.getName()).isPresent()) {
			throw new ResponseStatusException(HttpStatus.CONFLICT,
					"Name {" + player.getName() + "} exists, couldn't create player.");
		}
		if (repository.findByUuid(player.getUuid()).isPresent()) {
			throw new ResponseStatusException(HttpStatus.CONFLICT,
					"Uuid {" + player.getUuid() + "} exists, couldn't create player.");
		}
		player.setFirstLogin(Date.getCurrentDate());
		return repository.save(player);
	}

	@Override
	public PlayerModel update(long id, PlayerModel player) {
		repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Id {" + id + "} not found, couldn't update player."));
		if (repository.findByName(player.getName()).isPresent()
				&& repository.findByName(player.getName()).get().getId() != id) {
			throw new ResponseStatusException(HttpStatus.CONFLICT,
					"Name {" + player.getName() + "} exists, couldn't update player.");
		}
		if (repository.findByUuid(player.getUuid()).isPresent()
				&& repository.findByUuid(player.getUuid()).get().getId() != id) {
			throw new ResponseStatusException(HttpStatus.CONFLICT,
					"Uuid {" + player.getUuid() + "} exists, couldn't update player.");
		}
		player.setId(id);
		return repository.save(player);
	}

	@Override
	public boolean delete(long id) {
		repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Id {" + id + "} not found, couldn't delete player."));
		repository.deleteById(id);
		return true;
	}

	@Override
	public PlayerModel getByUuid(String uuid) {
		return repository.findByUuid(uuid).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Uuid {" + uuid + "} not found, couldn't get player."));
	}

	@Override
	public PlayerModel getByName(String name) {
		return repository.findByName(name).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Name {" + name + "} not found, couldn't get player."));
	}

	@Override
	public List<PlayerModel> getByPrefix(String prefix) {
		List<PlayerModel> players = repository.findByPrefix(prefix);
		if (players.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Prefix {" + prefix + "} not found, couldn't get players.");
		}
		return players;
	}

	@Override
	public List<PlayerModel> getByNameColor(String nameColor) {
		List<PlayerModel> players = repository.findByNameColor(nameColor);
		if (players.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"NameColor {" + nameColor + "} not found, couldn't get players.");
		}
		return players;
	}

	@Override
	public List<PlayerModel> getByNameFormat(String nameFormat) {
		List<PlayerModel> players = repository.findByNameFormat(nameFormat);
		if (players.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"NameFormat {" + nameFormat + "} not found, couldn't get players.");
		}
		return players;
	}

	@Override
	public List<PlayerModel> getByPrefixColor(String prefixColor) {
		List<PlayerModel> players = repository.findByPrefixColor(prefixColor);
		if (players.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"PrefixColor {" + prefixColor + "} not found, couldn't get players.");
		}
		return players;
	}

	@Override
	public List<PlayerModel> getByPrefixFormat(String prefixFormat) {
		List<PlayerModel> players = repository.findByPrefixFormat(prefixFormat);
		if (players.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"PrefixFormat {" + prefixFormat + "} not found, couldn't get players.");
		}
		return players;
	}

	@Override
	public List<PlayerModel> getByTimePlayed(long timePlayed) {
		List<PlayerModel> players = repository.findByTimePlayed(timePlayed);
		if (players.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"TimePlayed {" + timePlayed + "} not found, couldn't get players.");
		}
		return players;
	}

}