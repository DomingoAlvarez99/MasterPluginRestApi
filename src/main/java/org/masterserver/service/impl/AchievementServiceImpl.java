package org.masterserver.service.impl;

import java.util.List;

import org.masterserver.model.AchievementModel;
import org.masterserver.repository.AchievementRepository;
import org.masterserver.repository.PlayerRepository;
import org.masterserver.service.AchievementService;
import org.masterserver.util.CustomDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AchievementServiceImpl implements AchievementService {

	@Autowired
	private AchievementRepository repository;

	@Autowired
	private PlayerRepository playerRepository;

	@Override
	public List<AchievementModel> getAll() {
		List<AchievementModel> achievements = repository.findAll();
		if (achievements.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Achievements not found.");
		}
		return achievements;
	}

	@Override
	public AchievementModel getById(long id) {
		return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Id {" + id + "} not found, couldn't get achievement."));
	}

	@Override
	public AchievementModel create(AchievementModel achievement) {
		if (achievement.getPlayer() != null) {
			playerRepository.findById(achievement.getPlayer().getId())
					.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
							"PlayerId {" + achievement.getPlayer().getId() + "} not found, couldn't create achievement."));
		}
		achievement.setDate(CustomDate.getCurrentDate());
		return repository.save(achievement);
	}

	@Override
	public AchievementModel update(long id, AchievementModel achievement) {
		AchievementModel old = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Id {" + id + "} not found, couldn't update achievement."));
		achievement.setId(id);
		achievement.setDate(old.getDate());
		if (achievement.getPlayer() != null) {
			playerRepository.findById(achievement.getPlayer().getId())
					.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
							"PlayerId {" + achievement.getPlayer().getId() + "} not found, couldn't update achievement."));
		}
		return repository.save(achievement);
	}

	@Override
	public boolean delete(long id) {
		repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Id {" + id + "} not found, couldn't delete achievement."));
		repository.deleteById(id);
		return true;
	}

	@Override
	public List<AchievementModel> getByName(String name) {
		List<AchievementModel> achievements = repository.findByName(name);
		if (achievements.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Name {" + name + "} not found, couldn't get achievements.");
		}
		return achievements;
	}

}