package org.masterserver.service.impl;

import java.util.List;

import org.masterserver.model.RankModel;
import org.masterserver.repository.RankRepository;
import org.masterserver.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class RankServiceImpl implements RankService {

	@Autowired
	private RankRepository repository;

	@Override
	public List<RankModel> getAll() {
		List<RankModel> ranks = repository.findAll();
		if (ranks.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ranks not found.");
		}
		return ranks;
	}

	@Override
	public RankModel getById(long id) {
		return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Id {" + id + "} not found, couldn't get rank."));
	}

	@Override
	public RankModel create(RankModel rank) {
		if (repository.findByName(rank.getName()).isPresent()) {
			throw  new ResponseStatusException(HttpStatus.CONFLICT,
					"Name {" + rank.getName() + "} exists, couldn't create rank.");
		}
		return repository.save(rank);
	}

	@Override
	public RankModel update(long id, RankModel rank) {
		rank.setId(id);
		if (repository.findByName(rank.getName()).isPresent() && repository.findByName(rank.getName()).get().getId() != id) {
			throw  new ResponseStatusException(HttpStatus.CONFLICT,
					"Name {" + rank.getName() + "} exists, couldn't create rank.");
		}
		return repository.save(rank);
	}

	@Override
	public boolean delete(long id) {
		repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Id {" + id + "} not found, couldn't delete rank."));
		repository.deleteById(id);
		return true;
	}

	@Override
	public RankModel getByName(String name) {
		return repository.findByName(name).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Name {" + name + "} not found, couldn't get rank."));
	}

}

