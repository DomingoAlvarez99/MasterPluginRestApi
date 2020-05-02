package org.masterserver.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.masterserver.exception.ResourceNotFoundException;
import org.masterserver.model.CommandModel;
import org.masterserver.repository.CommandRepository;
import org.masterserver.service.CommandServiceTests;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class CommandServiceImplTests implements CommandServiceTests {

	@Mock
	private CommandRepository repository;
	
	@InjectMocks
	private CommandServiceImpl service;
	
	@BeforeEach
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	@Override
	public void getAll() {
		Mockito.when(repository.findAll()).thenReturn(new ArrayList<CommandModel>());
		Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			List<CommandModel> commands = service.getAll();
			Assertions.assertNull(commands);
	    });
		Mockito.verify(repository, Mockito.times(1)).findAll();
	}

	@Test
	@Override
	public void getById() {
		CommandModel command = new CommandModel(1l, "seen", Calendar.getInstance(Locale.GERMANY), 12l);
		Mockito.when(repository.findById(Mockito.anyLong())).thenReturn(Optional.of(command));
		CommandModel result = service.getById(Mockito.anyLong());
		Assertions.assertEquals(1l, result.getId());
		Assertions.assertEquals("seen", result.getCommand());
		Assertions.assertNotNull(result.getDate());
		Assertions.assertEquals(12l, result.getPlayerId());
		Mockito.verify(repository, Mockito.times(1)).findById(Mockito.anyLong());
	}

	@Test
	@Override
	public void create() {
		CommandModel command = new CommandModel(1l, "seen", Calendar.getInstance(Locale.GERMANY), 12l);
		Mockito.when(repository.save(command)).thenReturn(command);
		CommandModel result = service.create(command);
		Assertions.assertEquals(1l, result.getId());
		Assertions.assertEquals("seen", result.getCommand());
		Assertions.assertNotNull(result.getDate());
		Assertions.assertEquals(12l, result.getPlayerId());
		Mockito.verify(repository, Mockito.times(1)).save(command);
	}

	@Test
	@Override
	public void update() {
		CommandModel command = new CommandModel(1l, "seen", Calendar.getInstance(Locale.GERMANY), 12l);
		Mockito.when(repository.save(command)).thenReturn(command);
		Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			service.update(Mockito.anyLong(), command);
	    });
		Mockito.verify(repository, Mockito.times(1)).findById(Mockito.anyLong());
		Mockito.verify(repository, Mockito.times(0)).save(command);
	}

	@Test
	@Override
	public void delete() {
		Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			service.delete(Mockito.anyLong());
	    });
		Mockito.verify(repository, Mockito.times(1)).findById(Mockito.anyLong());
		Mockito.verify(repository, Mockito.times(0)).deleteById(Mockito.anyLong());
	}

	@Test
	@Override
	public void getByPlayerId() {
		Mockito.when(repository.findByPlayerId(Mockito.anyLong())).thenReturn(new ArrayList<CommandModel>());
		Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			List<CommandModel> commands = service.getByPlayerId(Mockito.anyLong());
			Assertions.assertNull(commands);
	    });
		Mockito.verify(repository, Mockito.times(1)).findByPlayerId(Mockito.anyLong());
	}

	@Test
	@Override
	public void getByCommand() {
		Mockito.when(repository.findByCommand(Mockito.anyString())).thenReturn(new ArrayList<CommandModel>());
		Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			List<CommandModel> commands = service.getByCommand(Mockito.anyString());
			Assertions.assertNull(commands);
	    });
		Mockito.verify(repository, Mockito.times(1)).findByCommand(Mockito.anyString());
	}

	@Test
	@Override
	public void getByDate() {
		Mockito.when(repository.findByDate(Mockito.any())).thenReturn(new ArrayList<CommandModel>());
		Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			List<CommandModel> commands = service.getByDate(Mockito.any());
			Assertions.assertNull(commands);
	    });
		Mockito.verify(repository, Mockito.times(1)).findByDate(Mockito.any());
	}

}
