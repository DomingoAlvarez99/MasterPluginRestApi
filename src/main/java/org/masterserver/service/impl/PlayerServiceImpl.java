package org.masterserver.service.impl;

import java.util.Calendar;
import java.util.List;

import org.masterserver.exception.ResourceExistsException;
import org.masterserver.exception.ResourceNotFoundException;
import org.masterserver.model.PlayerModel;
import org.masterserver.repository.PlayerRepository;
import org.masterserver.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	private PlayerRepository repository;

	@Override
	public List<PlayerModel> getAll() {
		List<PlayerModel> players = repository.findAll();
		if (players.isEmpty()) {
			throw new ResourceNotFoundException("Players not found.");
		}
		return repository.findAll();
	}

	@Override
	public PlayerModel getById(long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id {" + id + "} not found, couldn't get player."));
	}

	@Override
	public PlayerModel create(PlayerModel player) {
		if (repository.findByName(player.getName()).isPresent()) {
			throw new ResourceExistsException("Name {" + player.getName() + "} exists, couldn't create player.");
		}
		if (repository.findByUuid(player.getUuid()).isPresent()) {
			throw new ResourceExistsException("Uuid {" + player.getUuid() + "} exists, couldn't create player.");
		}
		return repository.save(player);
	}

	@Override
	public PlayerModel update(long id, PlayerModel player) {
		repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id {" + id + "} not found, couldn't update player."));
		player.setId(id);
		return repository.save(player);
	}

	@Override
	public boolean delete(long id) {
		repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id {" + id + "} not found, couldn't delete player."));
		repository.deleteById(id);
		return true;
	}

	@Override
	public PlayerModel getByUuid(String uuid) {
		return repository.findByUuid(uuid).orElseThrow(() -> new ResourceNotFoundException("Uuid {" + uuid + "} not found, couldn't get player."));
	}
	
	@Override
	public PlayerModel getByName(String name) {
		return repository.findByName(name).orElseThrow(() -> new ResourceNotFoundException("Name {" + name + "} not found, couldn't get player."));
	}

	@Override
	public List<PlayerModel> getByPrefix(String prefix) {
		List<PlayerModel> players = repository.findByPrefix(prefix);
		if (players.isEmpty()) {
			throw new ResourceNotFoundException("Prefix {" + prefix + "} not found, couldn't get players.");
		}
		return players;
	}

	@Override
	public List<PlayerModel> getByNameColor(String nameColor) {
		List<PlayerModel> players = repository.findByNameColor(nameColor);
		if (players.isEmpty()) {
			throw new ResourceNotFoundException("NameColor {" + nameColor + "} not found, couldn't get players.");
		}
		return players;
	}

	@Override
	public List<PlayerModel> getByNameFormat(String nameFormat) {
		List<PlayerModel> players = repository.findByNameFormat(nameFormat);
		if (players.isEmpty()) {
			throw new ResourceNotFoundException("NameFormat {" + nameFormat + "} not found, couldn't get players.");
		}
		return players;
	}

	@Override
	public List<PlayerModel> getByPrefixColor(String prefixColor) {
		List<PlayerModel> players = repository.findByPrefixColor(prefixColor);
		if (players.isEmpty()) {
			throw new ResourceNotFoundException("PrefixColor {" + prefixColor + "} not found, couldn't get players.");
		}
		return players;
	}

	@Override
	public List<PlayerModel> getByPrefixFormat(String prefixFormat) {
		List<PlayerModel> players = repository.findByPrefixFormat(prefixFormat);
		if (players.isEmpty()) {
			throw new ResourceNotFoundException("PrefixFormat {" + prefixFormat + "} not found, couldn't get players.");
		}
		return players;
	}

	@Override
	public List<PlayerModel> getByFirstLogin(Calendar firstLogin) {
		List<PlayerModel> players = repository.findByFirstLogin(firstLogin);
		if (players.isEmpty()) {
			throw new ResourceNotFoundException("FirstLogin {" + firstLogin + "} not found, couldn't get players.");
		}
		return players;
	}

	@Override
	public List<PlayerModel> getByLastLogin(Calendar lastLogin) {
		List<PlayerModel> players = repository.findByLastLogin(lastLogin);
		if (players.isEmpty()) {
			throw new ResourceNotFoundException("LastLogin {" + lastLogin + "} not found, couldn't get players.");
		}
		return players;
	}

	@Override
	public List<PlayerModel> getByTimePlayed(long timePlayed) {
		List<PlayerModel> players = repository.findByTimePlayed(timePlayed);
		if (players.isEmpty()) {
			throw new ResourceNotFoundException("TimePlayed {" + timePlayed + "} not found, couldn't get players.");
		}
		return players;
	}
	
}