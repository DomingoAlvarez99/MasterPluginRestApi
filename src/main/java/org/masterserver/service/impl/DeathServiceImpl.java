package org.masterserver.service.impl;

import java.util.Calendar;
import java.util.List;

import org.masterserver.exception.ResourceNotFoundException;
import org.masterserver.model.DeathModel;
import org.masterserver.repository.DeathRepository;
import org.masterserver.service.DeathService;
import org.masterserver.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeathServiceImpl implements DeathService {

	@Autowired
	private DeathRepository repository;

	@Override
	public List<DeathModel> getAll() {
		return repository.findAll();
	}

	@Override
	public DeathModel getById(long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Death not found."));
	}

	@Override
	public DeathModel create(DeathModel object) {
		object.setDate(Date.getCurrentDate());
		return repository.save(object);
	}

	@Override
	public DeathModel update(long id, DeathModel commandModel) {
		repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Death not found, can't update the command."));
		commandModel.setId(id);
		return repository.save(commandModel);
	}

	@Override
	public void delete(long id) {
		repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Death not found, can't delete the command."));
		repository.deleteById(id);
	}

	@Override
	public List<DeathModel> findByDate(Calendar date) {
		return repository.findByDate(date);
	}

	@Override
	public List<DeathModel> findByCause(String cause) {
		return repository.findByCause(cause);
	}

	@Override
	public List<DeathModel> findByMobId(long mobId) {
		return repository.findByMobId(mobId);
	}

	@Override
	public List<DeathModel> findByAssasinId(long assasinId) {
		return repository.findByAssasinId(assasinId);
	}

	@Override
	public List<DeathModel> findByMurderedId(long murderedId) {
		return repository.findByMurderedId(murderedId);
	}
	
}