package org.masterserver.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.masterserver.model.CommandModel;
import org.masterserver.repository.CommandRepository;
import org.masterserver.service.CommandServiceTests;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.web.server.ResponseStatusException;

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
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			List<CommandModel> commands = service.getAll();
			Assertions.assertNull(commands);
	    });
		Mockito.verify(repository, Mockito.times(1)).findAll();
	}

	@Test
	@Override
	public void getById() {
		CommandModel command = new CommandModel(1l, "seen", Calendar.getInstance(Locale.GERMANY));
		Mockito.when(repository.findById(Mockito.anyLong())).thenReturn(Optional.of(command));
		CommandModel result = service.getById(Mockito.anyLong());
		Assertions.assertEquals(1l, result.getId());
		Assertions.assertEquals("seen", result.getCommand());
		Assertions.assertNotNull(result.getDate());
		Mockito.verify(repository, Mockito.times(1)).findById(Mockito.anyLong());
	}

	@Test
	@Override
	public void create() {
		CommandModel command = new CommandModel(1l, "seen", Calendar.getInstance(Locale.GERMANY));
		Mockito.when(repository.save(command)).thenReturn(command);
		CommandModel result = service.create(command);
		Assertions.assertEquals(1l, result.getId());
		Assertions.assertEquals("seen", result.getCommand());
		Assertions.assertNotNull(result.getDate());
		Mockito.verify(repository, Mockito.times(1)).save(command);
	}

	@Test
	@Override
	public void update() {
		CommandModel command = new CommandModel(1l, "seen", Calendar.getInstance(Locale.GERMANY));
		Mockito.when(repository.save(command)).thenReturn(command);
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			service.update(Mockito.anyLong(), command);
	    });
		Mockito.verify(repository, Mockito.times(1)).findById(Mockito.anyLong());
		Mockito.verify(repository, Mockito.times(0)).save(command);
	}

	@Test
	@Override
	public void delete() {
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			service.delete(Mockito.anyLong());
	    });
		Mockito.verify(repository, Mockito.times(1)).findById(Mockito.anyLong());
		Mockito.verify(repository, Mockito.times(0)).deleteById(Mockito.anyLong());
	}

	@Test
	@Override
	public void getByCommand() {
		Mockito.when(repository.findByCommand(Mockito.anyString())).thenReturn(new ArrayList<CommandModel>());
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			List<CommandModel> commands = service.getByCommand(Mockito.anyString());
			Assertions.assertNull(commands);
	    });
		Mockito.verify(repository, Mockito.times(1)).findByCommand(Mockito.anyString());
	}

}
