package org.masterserver.service.impl;

import java.util.List;

import org.masterserver.model.PlayerModel;
import org.masterserver.model.RankModel;
import org.masterserver.repository.PlayerRepository;
import org.masterserver.repository.RankRepository;
import org.masterserver.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	private PlayerRepository playerRepository;

	@Autowired
	private RankRepository rankRepository;

	@Override
	public List<PlayerModel> getAll() {
		List<PlayerModel> players = playerRepository.findAll();
		if (players.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Players not found.");
		}
		return playerRepository.findAll();
	}

	@Override
	public PlayerModel getById(long id) {
		return playerRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Id {" + id + "} not found, couldn't get player."));
	}

	@Override
	public PlayerModel create(PlayerModel player) {
		if (playerRepository.findByName(player.getName()).isPresent()) {
			throw new ResponseStatusException(HttpStatus.CONFLICT,
					"Name {" + player.getName() + "} exists, couldn't create player.");
		}
		if (playerRepository.findByUuid(player.getUuid()).isPresent()) {
			throw new ResponseStatusException(HttpStatus.CONFLICT,
					"Uuid {" + player.getUuid() + "} exists, couldn't create player.");
		}
		return playerRepository.save(player);
	}

	@Override
	public PlayerModel update(long id, PlayerModel player) {
		PlayerModel old = playerRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						"Id {" + id + "} not found, couldn't update player."));
		if (playerRepository.findByName(player.getName()).isPresent()
				&& playerRepository.findByName(player.getName()).get().getId() != id) {
			throw new ResponseStatusException(HttpStatus.CONFLICT,
					"Name {" + player.getName() + "} exists, couldn't update player.");
		}
		if (playerRepository.findByUuid(player.getUuid()).isPresent()
				&& playerRepository.findByUuid(player.getUuid()).get().getId() != id) {
			throw new ResponseStatusException(HttpStatus.CONFLICT,
					"Uuid {" + player.getUuid() + "} exists, couldn't update player.");
		}
		player.setFirstLogin(old.getFirstLogin());
		player.setId(id);
		return playerRepository.save(player);
	}

	@Override
	public boolean delete(long id) {
		playerRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Id {" + id + "} not found, couldn't delete player."));
		playerRepository.deleteById(id);
		return true;
	}

	@Override
	public PlayerModel getByUuid(String uuid) {
		return playerRepository.findByUuid(uuid).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Uuid {" + uuid + "} not found, couldn't get player."));
	}

	@Override
	public PlayerModel getByName(String name) {
		return playerRepository.findByName(name).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Name {" + name + "} not found, couldn't get player."));
	}

	@Override
	public List<PlayerModel> getByPrefix(String prefix) {
		List<PlayerModel> players = playerRepository.findByPrefix(prefix);
		if (players.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Prefix {" + prefix + "} not found, couldn't get players.");
		}
		return players;
	}

	@Override
	public List<PlayerModel> getByNameColor(String nameColor) {
		List<PlayerModel> players = playerRepository.findByNameColor(nameColor);
		if (players.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"NameColor {" + nameColor + "} not found, couldn't get players.");
		}
		return players;
	}

	@Override
	public List<PlayerModel> getByNameFormat(String nameFormat) {
		List<PlayerModel> players = playerRepository.findByNameFormat(nameFormat);
		if (players.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"NameFormat {" + nameFormat + "} not found, couldn't get players.");
		}
		return players;
	}

	@Override
	public List<PlayerModel> getByPrefixColor(String prefixColor) {
		List<PlayerModel> players = playerRepository.findByPrefixColor(prefixColor);
		if (players.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"PrefixColor {" + prefixColor + "} not found, couldn't get players.");
		}
		return players;
	}

	@Override
	public List<PlayerModel> getByPrefixFormat(String prefixFormat) {
		List<PlayerModel> players = playerRepository.findByPrefixFormat(prefixFormat);
		if (players.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"PrefixFormat {" + prefixFormat + "} not found, couldn't get players.");
		}
		return players;
	}

	@Override
	public List<PlayerModel> getByTimePlayed(long timePlayed) {
		List<PlayerModel> players = playerRepository.findByTimePlayed(timePlayed);
		if (players.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"TimePlayed {" + timePlayed + "} not found, couldn't get players.");
		}
		return players;
	}

	@Override
	public List<PlayerModel> getByRankName(String rankName) {
		RankModel rank = rankRepository.findByName(rankName)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						"RankName {" + rankName + "} not found, couldn't get players."));
		List<PlayerModel> players = playerRepository.findByRank(rank);
		if (players.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Players with rank {" + rankName + "} not found, couldn't get players.");
		}
		return players;
	}

}