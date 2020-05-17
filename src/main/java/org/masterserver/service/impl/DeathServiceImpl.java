package org.masterserver.service.impl;

import java.util.List;

import org.masterserver.model.DeathModel;
import org.masterserver.repository.DeathRepository;
import org.masterserver.repository.PlayerRepository;
import org.masterserver.service.DeathService;
import org.masterserver.util.CustomDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class DeathServiceImpl implements DeathService {

	@Autowired
	private DeathRepository repository;

	@Autowired
	private PlayerRepository playerRepository;

	@Override
	public List<DeathModel> getAll() {
		List<DeathModel> deaths = repository.findAll();
		if (deaths.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Deaths not found.");
		}
		return deaths;
	}

	@Override
	public DeathModel getById(long id) {
		return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Id {" + id + "} not found, couldn't get death."));
	}

	@Override
	public DeathModel create(DeathModel death) {
		if (death.getAssasin() != null) {
			playerRepository.findById(death.getAssasin().getId())
					.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
							"AssasinId {" + death.getAssasin().getId() + "} not found, couldn't create death."));
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"AssasinId {" + death.getAssasin().getId() + "} not found, couldn't create death.");
		}
		if (death.getMurdered() != null) {
			playerRepository.findById(death.getMurdered().getId())
					.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
							"MurderedId {" + death.getMurdered().getId() + "} not found, couldn't create death."));
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"MurderedId {" + death.getMurdered().getId() + "} not found, couldn't create death.");
		}
		death.setDate(CustomDate.getCurrentDate());
		return repository.save(death);
	}

	@Override
	public DeathModel update(long id, DeathModel death) {
		DeathModel old = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Id {" + id + "} not found, couldn't update death."));
		death.setId(id);
		death.setDate(old.getDate());
		if (death.getAssasin() != null) {
			playerRepository.findById(death.getAssasin().getId())
					.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
							"AssasinId {" + death.getAssasin().getId() + "} not found, couldn't update death."));
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"AssasinId {" + death.getAssasin().getId() + "} not found, couldn't update death.");
		}
		if (death.getMurdered() != null) {
			playerRepository.findById(death.getMurdered().getId())
					.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
							"MurderedId {" + death.getMurdered().getId() + "} not found, couldn't update death."));
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"MurderedId {" + death.getMurdered().getId() + "} not found, couldn't update death.");
		}
		return repository.save(death);
	}

	@Override
	public boolean delete(long id) {
		repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Id {" + id + "} not found, couldn't delete death."));
		repository.deleteById(id);
		return true;
	}

	@Override
	public List<DeathModel> getByCause(String cause) {
		List<DeathModel> deaths = repository.findByCause(cause);
		if (deaths.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Cause {" + cause + "} not found, couldn't get deaths.");
		}
		return deaths;
	}

}