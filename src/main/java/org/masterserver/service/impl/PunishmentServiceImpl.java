package org.masterserver.service.impl;

import java.util.Calendar;
import java.util.List;

import org.masterserver.model.PunishmentModel;
import org.masterserver.repository.PlayerRepository;
import org.masterserver.repository.PunishmentRepository;
import org.masterserver.service.PunishmentService;
import org.masterserver.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PunishmentServiceImpl implements PunishmentService {

	@Autowired
	private PunishmentRepository repository;

	@Autowired
	private PlayerRepository playerRepository;

	@Override
	public List<PunishmentModel> getAll() {
		List<PunishmentModel> punishments = repository.findAll();
		if (punishments.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Punishments not found.");
		}
		return repository.findAll();
	}

	@Override
	public PunishmentModel getById(long id) {
		return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Id {" + id + "} not found, couldn't get punishment."));
	}

	@Override
	public PunishmentModel create(PunishmentModel punishment) {
		if (punishment.getPlayer() != null) {
			playerRepository.findById(punishment.getPlayer().getId()).orElseThrow(() -> new ResponseStatusException(
					HttpStatus.NOT_FOUND,
					"PlayerId {" + punishment.getPlayer().getId() + "} not found, couldn't create punishment."));
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"PlayerId {" + punishment.getPlayer().getId() + "} not found, couldn't create punishment.");
		}
		punishment.setDate(Date.getCurrentDate());
		return repository.save(punishment);
	}

	@Override
	public PunishmentModel update(long id, PunishmentModel punishment) {
		PunishmentModel old = repository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						"Id {" + id + "} not found, couldn't update punishment."));
		punishment.setId(id);
		punishment.setDate(old.getDate());
		if (punishment.getPlayer() != null) {
			playerRepository.findById(punishment.getPlayer().getId()).orElseThrow(() -> new ResponseStatusException(
					HttpStatus.NOT_FOUND,
					"PlayerId {" + punishment.getPlayer().getId() + "} not found, couldn't update punishment."));
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"PlayerId {" + punishment.getPlayer().getId() + "} not found, couldn't update punishment.");
		}
		return repository.save(punishment);
	}

	@Override
	public boolean delete(long id) {
		repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Id {" + id + "} not found, couldn't delete punishment."));
		repository.deleteById(id);
		return true;
	}

	@Override
	public List<PunishmentModel> getByDate(Calendar date) {
		List<PunishmentModel> punishments = repository.findByDate(date);
		if (punishments.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Date {" + date + "} not found, couldn't get punishments.");
		}
		return punishments;
	}

	@Override
	public List<PunishmentModel> getByType(String type) {
		List<PunishmentModel> punishments = repository.findByType(type);
		if (punishments.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Type {" + type + "} not found, couldn't get punishments.");
		}
		return punishments;
	}

	@Override
	public List<PunishmentModel> getByDescription(String type) {
		List<PunishmentModel> punishments = repository.findByDescription(type);
		if (punishments.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Type {" + type + "} not found, couldn't get punishments.");
		}
		return punishments;
	}

}