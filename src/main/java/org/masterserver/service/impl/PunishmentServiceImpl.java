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
		return repository.findAll();
	}

	@Override
	public PunishmentModel getById(long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Punishment not found."));
	}

	@Override
	public PunishmentModel create(PunishmentModel object) {
		return repository.save(object);
	}

	@Override
	public PunishmentModel update(long id, PunishmentModel commandModel) {
		repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Punishment not found, can't update the command."));
		commandModel.setId(id);
		return repository.save(commandModel);
	}

	@Override
	public void delete(long id) {
		repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Punishment not found, can't delete the command."));
		repository.deleteById(id);
	}

	@Override
	public List<PunishmentModel> findByDate(Calendar date) {
		return repository.findByDate(date);
	}

	@Override
	public List<PunishmentModel> findByType(String type) {
		return repository.findByType(type);
	}

	@Override
	public List<PunishmentModel> findByDescription(String type) {
		return repository.findByDescription(type);
	}

	@Override
	public List<PunishmentModel> findByPlayerId(long playerId) {
		return repository.findByPlayerId(playerId);
	}
	
}