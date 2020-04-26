package org.masterserver.service.impl;

import java.util.List;

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
		return repository.findAll();
	}

	@Override
	public PlayerModel getById(long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Player not found."));
	}

	@Override
	public PlayerModel create(PlayerModel object) {
		return repository.save(object);
	}

	@Override
	public PlayerModel update(long id, PlayerModel commandModel) {
		repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Player not found, can't update the command."));
		commandModel.setId(id);
		return repository.save(commandModel);
	}

	@Override
	public void delete(long id) {
		repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Player not found, can't delete the command."));
		repository.deleteById(id);
	}

	@Override
	public PlayerModel findByUuid(String uuid) {
		return repository.findByUuid(uuid).orElseThrow(() -> new ResourceNotFoundException("Player not found."));
	}
	
	@Override
	public PlayerModel findByName(String name) {
		return repository.findByName(name).orElseThrow(() -> new ResourceNotFoundException("Player not found."));
	}

	@Override
	public List<PlayerModel> findByPrefix(String prefix) {
		return repository.findByPrefix(prefix);
	}

	@Override
	public List<PlayerModel> findByNameColor(String nameColor) {
		return repository.findByNameColor(nameColor);
	}

	@Override
	public List<PlayerModel> findByNameFormat(String nameFormat) {
		return repository.findByNameFormat(nameFormat);
	}

	@Override
	public List<PlayerModel> findByPrefixColor(String prefixColor) {
		return repository.findByPrefixColor(prefixColor);
	}

	@Override
	public List<PlayerModel> findByPrefixFormat(String prefixFormat) {
		return repository.findByPrefixFormat(prefixFormat);
	}

	@Override
	public List<PlayerModel> findByFirstLogin(String firstLogin) {
		return repository.findByFirstLogin(firstLogin);
	}

	@Override
	public List<PlayerModel> findByLastLogin(String lastLogin) {
		return repository.findByLastLogin(lastLogin);
	}

	@Override
	public List<PlayerModel> findByTimePlayed(String timePlayed) {
		return repository.findByTimePlayed(timePlayed);
	}
	
}