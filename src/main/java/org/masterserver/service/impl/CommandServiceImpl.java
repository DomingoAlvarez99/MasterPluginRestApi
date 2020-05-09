package org.masterserver.service.impl;

import java.util.List;

import org.masterserver.model.CommandModel;
import org.masterserver.repository.CommandRepository;
import org.masterserver.repository.PlayerRepository;
import org.masterserver.service.CommandService;
import org.masterserver.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CommandServiceImpl implements CommandService {

	@Autowired
	private CommandRepository repository;

	@Autowired
	private PlayerRepository playerRepository;

	@Override
	public List<CommandModel> getAll() {
		List<CommandModel> commands = repository.findAll();
		if (commands.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Commands not found.");
		}
		return commands;
	}

	@Override
	public CommandModel getById(long id) {
		return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Id {" + id + "} not found, couldn't get command."));
	}

	@Override
	public CommandModel create(CommandModel command) {
		if (command.getPlayer() != null) {
			playerRepository.findById(command.getPlayer().getId())
					.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
							"PlayerId {" + command.getPlayer().getId() + "} not found, couldn't create command."));
		}
		command.setDate(Date.getCurrentDate());
		return repository.save(command);
	}

	@Override
	public CommandModel update(long id, CommandModel command) {
		CommandModel old = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Id {" + id + "} not found, couldn't update command."));
		command.setId(id);
		command.setDate(old.getDate());
		if (command.getPlayer() != null) {
			playerRepository.findById(command.getPlayer().getId())
					.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
							"PlayerId {" + command.getPlayer().getId() + "} not found, couldn't update command."));
		}
		return repository.save(command);
	}

	@Override
	public boolean delete(long id) {
		repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Id {" + id + "} not found, couldn't delete command."));
		repository.deleteById(id);
		return true;
	}

	@Override
	public List<CommandModel> getByCommand(String command) {
		List<CommandModel> commands = repository.findByCommand(command);
		if (commands.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Command {" + command + "} not found, couldn't get commands.");
		}
		return commands;
	}

}