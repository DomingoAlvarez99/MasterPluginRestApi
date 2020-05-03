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
		List<DeathModel> deaths = repository.findAll();
		if (deaths.isEmpty()) {
			throw new ResourceNotFoundException("Deaths not found.");
		}
		return deaths;
	}

	@Override
	public DeathModel getById(long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found, couldn't get death."));
	}

	@Override
	public DeathModel create(DeathModel object) {
		object.setDate(Date.getCurrentDate());
		return repository.save(object);
	}

	@Override
	public DeathModel update(long id, DeathModel commandModel) {
		repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found, couldn't update death."));
		commandModel.setId(id);
		return repository.save(commandModel);
	}

	@Override
	public boolean delete(long id) {
		repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found, couldn't delete death."));
		repository.deleteById(id);
		return true;
	}

	@Override
	public List<DeathModel> getByDate(Calendar date) {
		List<DeathModel> deaths = repository.findByDate(date);
		if (deaths.isEmpty()) {
			throw new ResourceNotFoundException("Date not found, couldn't get deaths.");
		}
		return deaths;
	}

	@Override
	public List<DeathModel> getByCause(String cause) {
		List<DeathModel> deaths = repository.findByCause(cause);
		if (deaths.isEmpty()) {
			throw new ResourceNotFoundException("Cause not found, couldn't get deaths.");
		}
		return deaths;
	}

	@Override
	public List<DeathModel> getByMobId(long mobId) {
		List<DeathModel> deaths = repository.findByMobId(mobId);
		if (deaths.isEmpty()) {
			throw new ResourceNotFoundException("MobId not found, couldn't get deaths.");
		}
		return deaths;
	}

	@Override
	public List<DeathModel> getByAssasinId(long assasinId) {
		List<DeathModel> deaths = repository.findByAssasinId(assasinId);
		if (deaths.isEmpty()) {
			throw new ResourceNotFoundException("AssasinId not found, couldn't get deaths.");
		}
		return deaths;
	}

	@Override
	public List<DeathModel> getByMurderedId(long murderedId) {
		List<DeathModel> deaths = repository.findByMurderedId(murderedId);
		if (deaths.isEmpty()) {
			throw new ResourceNotFoundException("MurderedId not found, couldn't get deaths.");
		}
		return deaths;
	}
	
}