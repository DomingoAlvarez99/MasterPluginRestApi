package org.masterserver.service.impl;

import java.util.List;

import org.masterserver.model.PermissionModel;
import org.masterserver.repository.PermissionRepository;
import org.masterserver.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	private PermissionRepository repository;

	@Override
	public List<PermissionModel> getAll() {
		List<PermissionModel> permissions = repository.findAll();
		if (permissions.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Permissions not found.");
		}
		return permissions;
	}

	@Override
	public PermissionModel getById(long id) {
		return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Id {" + id + "} not found, couldn't get permission."));
	}

	@Override
	public PermissionModel create(PermissionModel permission) {
		if (repository.findByName(permission.getName()).isPresent()) {
			throw  new ResponseStatusException(HttpStatus.CONFLICT,
					"Name {" + permission.getName() + "} exists, couldn't create permission.");
		}
		return repository.save(permission);
	}

	@Override
	public PermissionModel update(long id, PermissionModel permission) {
		permission.setId(id);
		if (repository.findByName(permission.getName()).isPresent() && repository.findByName(permission.getName()).get().getId() != id) {
			throw  new ResponseStatusException(HttpStatus.CONFLICT,
					"Name {" + permission.getName() + "} exists, couldn't create permission.");
		}
		return repository.save(permission);
	}

	@Override
	public boolean delete(long id) {
		repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Id {" + id + "} not found, couldn't delete permission."));
		repository.deleteById(id);
		return true;
	}

	@Override
	public PermissionModel getByName(String name) {
		return repository.findByName(name).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Name {" + name + "} not found, couldn't get permission."));
	}

}
