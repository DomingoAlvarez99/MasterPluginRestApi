package org.masterserver.service.impl;

import java.util.Calendar;
import java.util.List;

import org.masterserver.exception.ResourceNotFoundException;
import org.masterserver.model.CommandModel;
import org.masterserver.repository.CommandRepository;
import org.masterserver.service.CommandService;
import org.masterserver.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommandServiceImpl implements CommandService {

	@Autowired
	private CommandRepository repository;

	@Override
	public List<CommandModel> getAll() {
		List<CommandModel> commands = repository.findAll();
		if (commands.isEmpty()) {
			throw new ResourceNotFoundException("Commands not found.");
		}
		return commands;
	}

	@Override
	public CommandModel getById(long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found, couldn't get command."));
	}

	@Override
	public CommandModel create(CommandModel object) {
		object.setDate(Date.getCurrentDate());
		return repository.save(object);
	}

	@Override
	public CommandModel update(long id, CommandModel commandModel) {
		repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found, couldn't get command."));
		commandModel.setId(id);
		return repository.save(commandModel);
	}

	@Override
	public void delete(long id) {
		repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found, couldn't get command."));
		repository.deleteById(id);
	}

	@Override
	public List<CommandModel> getByPlayerId(long playerId) {
		List<CommandModel> commands = repository.findByPlayerId(playerId);
		if (commands.isEmpty()) {
			throw new ResourceNotFoundException("PlayerId not found, couldn't get commands.");
		}
		return commands;
	}

	@Override
	public List<CommandModel> getByCommand(String command) {
		List<CommandModel> commands = repository.findByCommand(command);
		if (commands.isEmpty()) {
			throw new ResourceNotFoundException("Command not found, couldn't get commands.");
		}
		return commands;
	}

	@Override
	public List<CommandModel> getByDate(Calendar date) {
		List<CommandModel> commands = repository.findByDate(date);
		if (commands.isEmpty()) {
			throw new ResourceNotFoundException("Date not found, couldn't get commands.");
		}
		return commands;
	}
	
}