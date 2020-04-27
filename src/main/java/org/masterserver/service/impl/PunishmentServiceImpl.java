package org.masterserver.service.impl;

import java.util.Calendar;
import java.util.List;

import org.masterserver.exception.ResourceNotFoundException;
import org.masterserver.model.PunishmentModel;
import org.masterserver.repository.PunishmentRepository;
import org.masterserver.service.PunishmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PunishmentServiceImpl implements PunishmentService {

	@Autowired
	private PunishmentRepository repository;

	@Override
	public List<PunishmentModel> getAll() {
		List<PunishmentModel> punishments = repository.findAll();
		if (punishments.isEmpty()) {
			throw new ResourceNotFoundException("Punishments not found.");
		}
		return repository.findAll();
	}

	@Override
	public PunishmentModel getById(long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found, couldn't get punishment."));
	}

	@Override
	public PunishmentModel create(PunishmentModel object) {
		return repository.save(object);
	}

	@Override
	public PunishmentModel update(long id, PunishmentModel commandModel) {
		repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found, couldn't update punishment."));
		commandModel.setId(id);
		return repository.save(commandModel);
	}

	@Override
	public void delete(long id) {
		repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found, couldn't delete punishment."));
		repository.deleteById(id);
	}

	@Override
	public List<PunishmentModel>getByDate(Calendar date) {
		List<PunishmentModel> punishments = repository.findByDate(date);
		if (punishments.isEmpty()) {
			throw new ResourceNotFoundException("Date not found, couldn't get punishments.");
		}
		return punishments;
	}

	@Override
	public List<PunishmentModel> getByType(String type) {
		List<PunishmentModel> punishments = repository.findByType(type);
		if (punishments.isEmpty()) {
			throw new ResourceNotFoundException("Type not found, couldn't get punishments.");
		}
		return punishments;
	}

	@Override
	public List<PunishmentModel> getByDescription(String type) {
		List<PunishmentModel> punishments = repository.findByDescription(type);
		if (punishments.isEmpty()) {
			throw new ResourceNotFoundException("Type not found, couldn't get punishments.");
		}
		return punishments;
	}

	@Override
	public List<PunishmentModel> getByPlayerId(long playerId) {
		List<PunishmentModel> punishments = repository.findByPlayerId(playerId);
		if (punishments.isEmpty()) {
			throw new ResourceNotFoundException("PlayerId not found, couldn't get punishments.");
		}
		return punishments;
	}
	
}