package org.masterserver.service.impl;

import java.util.List;

import org.masterserver.model.PlayerModel;
import org.masterserver.model.WarpModel;
import org.masterserver.repository.PlayerRepository;
import org.masterserver.repository.WarpRepository;
import org.masterserver.service.WarpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class WarpServiceImpl implements WarpService {

	@Autowired
	private WarpRepository repository;

	@Autowired
	private PlayerRepository playerRepository;

	@Override
	public List<WarpModel> getAll() {
		List<WarpModel> warps = repository.findAll();
		if (warps.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Warps not found.");
		}
		return warps;
	}

	@Override
	public WarpModel getById(long id) {
		return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Id {" + id + "} not found, couldn't get warp."));
	}

	@Override
	public WarpModel create(WarpModel warp) {
		if (warp.getPlayer() != null) {
			PlayerModel player = playerRepository.findById(warp.getPlayer().getId())
					.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
							"PlayerId {" + warp.getPlayer().getId() + "} not found, couldn't create warp."));
			if (repository.findByNameAndPlayer(warp.getName(), player).isPresent()) {
				throw new ResponseStatusException(HttpStatus.CONFLICT, "Name {" + warp.getName()
						+ "} exists for playerId {" + player.getId() + "}, couldn't create warp.");
			}
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"PlayerId {" + warp.getPlayer() + "} not found, couldn't create warp.");
		}
		return repository.save(warp);
	}

	@Override
	public WarpModel update(long id, WarpModel warp) {
		repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Warp {" + id + "} not found, couldn't update warp."));
		warp.setId(id);
		if (warp.getPlayer() != null) {
			PlayerModel player = playerRepository.findById(warp.getPlayer().getId())
					.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
							"PlayerId {" + warp.getPlayer().getId() + "} not found, couldn't update warp."));
			if (repository.findByNameAndPlayer(warp.getName(), player).isPresent()) {
				throw new ResponseStatusException(HttpStatus.CONFLICT, "Name {" + warp.getName()
						+ "} exists for playerId {" + player.getId() + "}, couldn't update warp.");
			}
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"PlayerId {" + warp.getPlayer() + "} not found, couldn't update warp.");
		}
		return repository.save(warp);
	}

	@Override
	public boolean delete(long id) {
		repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Warp {" + id + "} not found, couldn't delete warp."));
		repository.deleteById(id);
		return true;
	}

	@Override
	public List<WarpModel> getByName(String name) {
		List<WarpModel> warps = repository.findByName(name);
		if (warps.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Name {" + name + "} not found, couldn't get warps.");
		}
		return warps;
	}

	@Override
	public List<WarpModel> getByCoordinateX(long coordinateX) {
		List<WarpModel> warps = repository.findByCoordinateX(coordinateX);
		if (warps.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"CoordinateX {" + coordinateX + "} not found, couldn't get warps.");
		}
		return warps;
	}

	@Override
	public List<WarpModel> getByCoordinateY(long coordinateY) {
		List<WarpModel> warps = repository.findByCoordinateY(coordinateY);
		if (warps.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"CoordinateY {" + coordinateY + "} not found, couldn't get warps.");
		}
		return warps;
	}

	@Override
	public List<WarpModel> getByCoordinateZ(long coordinateZ) {
		List<WarpModel> warps = repository.findByCoordinateZ(coordinateZ);
		if (warps.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"PlayerId {" + coordinateZ + "} not found, couldn't get warps.");
		}
		return warps;
	}

}