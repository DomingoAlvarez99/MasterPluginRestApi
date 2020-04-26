package org.masterserver.service.impl;

import java.util.List;

import org.masterserver.exception.ResourceNotFoundException;
import org.masterserver.model.WarpModel;
import org.masterserver.repository.WarpRepository;
import org.masterserver.service.WarpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WarpServiceImpl implements WarpService {

	@Autowired
	private WarpRepository repository;

	@Override
	public List<WarpModel> getAll() {
		return repository.findAll();
	}

	@Override
	public WarpModel getById(long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Warp not found."));
	}

	@Override
	public WarpModel create(WarpModel object) {
		return repository.save(object);
	}

	@Override
	public WarpModel update(long id, WarpModel commandModel) {
		repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Warp not found, can't update the command."));
		commandModel.setId(id);
		return repository.save(commandModel);
	}

	@Override
	public void delete(long id) {
		repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Warp not found, can't delete the command."));
		repository.deleteById(id);
	}

	@Override
	public List<WarpModel> findByName(String name) {
		return repository.findByName(name);
	}

	@Override
	public List<WarpModel> findByCoordinateX(long coordinateX) {
		return repository.findByCoordinateX(coordinateX);
	}

	@Override
	public List<WarpModel> findByCoordinateY(long coordinateY) {
		return repository.findByCoordinateY(coordinateY);
	}

	@Override
	public List<WarpModel> findByCoordinateZ(long coordinateZ) {
		return repository.findByCoordinateZ(coordinateZ);
	}

	@Override
	public List<WarpModel> findByPlayerId(long playerId) {
		return repository.findByPlayerId(playerId);
	}
	
}