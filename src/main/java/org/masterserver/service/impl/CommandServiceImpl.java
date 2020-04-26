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
		return repository.findAll();
	}

	@Override
	public CommandModel getById(long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Command not found."));
	}

	@Override
	public CommandModel create(CommandModel object) {
		object.setDate(Date.getCurrentDate());
		return repository.save(object);
	}

	@Override
	public CommandModel update(long id, CommandModel commandModel) {
		repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Command not found, can't update the command."));
		commandModel.setId(id);
		return repository.save(commandModel);
	}

	@Override
	public void delete(long id) {
		repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Command not found, can't delete the command."));
		repository.deleteById(id);
	}

	@Override
	public List<CommandModel> findByPlayerId(long playerId) {
		return repository.findByPlayerId(playerId);
	}

	@Override
	public List<CommandModel> findByCommand(String command) {
		return repository.findByCommand(command);
	}

	@Override
	public List<CommandModel> findByDate(Calendar date) {
		return repository.findByDate(date);
	}
	
}