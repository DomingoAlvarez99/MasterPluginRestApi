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
		List<WarpModel> warps = repository.findAll();
		if (warps.isEmpty()) {
			throw new ResourceNotFoundException("Warps not found.");
		}
		return warps;
	}

	@Override
	public WarpModel getById(long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found, couldn't get warp."));
	}

	@Override
	public WarpModel create(WarpModel object) {
		return repository.save(object);
	}

	@Override
	public WarpModel update(long id, WarpModel commandModel) {
		repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Warp not found, couldn't update warp."));
		commandModel.setId(id);
		return repository.save(commandModel);
	}

	@Override
	public boolean delete(long id) {
		repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Warp not found, couldn't delete warp."));
		repository.deleteById(id);
		return true;
	}

	@Override
	public List<WarpModel> getByName(String name) {
		List<WarpModel> warps = repository.findByName(name);
		if (warps.isEmpty()) {
			throw new ResourceNotFoundException("Name not found, couldn't get warps.");
		}
		return warps;
	}

	@Override
	public List<WarpModel> getByCoordinateX(long coordinateX) {
		List<WarpModel> warps = repository.findByCoordinateX(coordinateX);
		if (warps.isEmpty()) {
			throw new ResourceNotFoundException("CoordinateX not found, couldn't get warps.");
		}
		return warps;
	}

	@Override
	public List<WarpModel> getByCoordinateY(long coordinateY) {
		List<WarpModel> warps = repository.findByCoordinateY(coordinateY);
		if (warps.isEmpty()) {
			throw new ResourceNotFoundException("CoordinateY not found, couldn't get warps.");
		}
		return warps;
	}

	@Override
	public List<WarpModel> getByCoordinateZ(long coordinateZ) {
		List<WarpModel> warps = repository.findByCoordinateZ(coordinateZ);
		if (warps.isEmpty()) {
			throw new ResourceNotFoundException("PlayerId not found, couldn't get warps.");
		}
		return warps;
	}

	@Override
	public List<WarpModel> getByPlayerId(long playerId) {
		List<WarpModel> warps = repository.findByPlayerId(playerId);
		if (warps.isEmpty()) {
			throw new ResourceNotFoundException("PlayerId not found, couldn't get warps.");
		}
		return warps;
	}
	
}