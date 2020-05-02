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
import org.masterserver.model.PunishmentModel;
import org.masterserver.repository.PunishmentRepository;
import org.masterserver.service.PunishmentServiceTests;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class PunishmentServiceImplTests implements PunishmentServiceTests {

	@Mock
	private PunishmentRepository repository;
	
	@InjectMocks
	private PunishmentServiceImpl service;
	
	@BeforeEach
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	@Override
	public void getAll() {
		Mockito.when(repository.findAll()).thenReturn(new ArrayList<PunishmentModel>());
		Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			List<PunishmentModel> punishments = service.getAll();
			Assertions.assertNull(punishments);
	    });
		Mockito.verify(repository, Mockito.times(1)).findAll();
	}

	@Test
	@Override
	public void getById() {
		PunishmentModel punishment = new PunishmentModel(1l, "desc", "ban", Calendar.getInstance(Locale.GERMANY), 1l);
		Mockito.when(repository.findById(Mockito.anyLong())).thenReturn(Optional.of(punishment));
		PunishmentModel result = service.getById(Mockito.anyLong());
		Assertions.assertEquals(1l, result.getId());
		Assertions.assertEquals("desc", result.getDescription());
		Assertions.assertEquals("ban", result.getType());
		Assertions.assertNotNull(result.getDate());
		Assertions.assertEquals(1l, result.getPlayerId());
		Mockito.verify(repository, Mockito.times(1)).findById(Mockito.anyLong());
	}

	@Test
	@Override
	public void create() {
		PunishmentModel punishment = new PunishmentModel(1l, "desc", "ban", Calendar.getInstance(Locale.GERMANY), 1l);
		Mockito.when(repository.save(punishment)).thenReturn(punishment);
		PunishmentModel result = service.create(punishment);
		Assertions.assertEquals(1l, result.getId());
		Assertions.assertEquals("desc", result.getDescription());
		Assertions.assertEquals("ban", result.getType());
		Assertions.assertNotNull(result.getDate());
		Assertions.assertEquals(1l, result.getPlayerId());
		Mockito.verify(repository, Mockito.times(1)).save(punishment);
	}

	@Test
	@Override
	public void update() {
		PunishmentModel punishment = new PunishmentModel(1l, "desc", "ban", Calendar.getInstance(Locale.GERMANY), 1l);
		Mockito.when(repository.save(punishment)).thenReturn(punishment);
		Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			service.update(1l, punishment);
	    });
		Mockito.verify(repository, Mockito.times(1)).findById(Mockito.anyLong());
		Mockito.verify(repository, Mockito.times(0)).save(punishment);
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
	public void getByType() {
		Mockito.when(repository.findByType((Mockito.anyString()))).thenReturn(new ArrayList<PunishmentModel>());
		Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			List<PunishmentModel> punishments = service.getByType(Mockito.anyString());
			Assertions.assertNull(punishments);
	    });
		Mockito.verify(repository, Mockito.times(1)).findByType(Mockito.anyString());
	}

	@Test
	@Override
	public void getByDate() {
		Mockito.when(repository.findByDate((Mockito.any()))).thenReturn(new ArrayList<PunishmentModel>());
		Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			List<PunishmentModel> punishments = service.getByDate(Mockito.any());
			Assertions.assertNull(punishments);
	    });
		Mockito.verify(repository, Mockito.times(1)).findByDate(Mockito.any());
	}

	@Test
	@Override
	public void getByDescription() {
		Mockito.when(repository.findByDescription((Mockito.anyString()))).thenReturn(new ArrayList<PunishmentModel>());
		Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			List<PunishmentModel> punishments = service.getByDescription(Mockito.anyString());
			Assertions.assertNull(punishments);
	    });
		Mockito.verify(repository, Mockito.times(1)).findByDescription(Mockito.anyString());
	}

	@Test
	@Override
	public void getByPlayerId() {
		Mockito.when(repository.findByPlayerId((Mockito.anyLong()))).thenReturn(new ArrayList<PunishmentModel>());
		Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			List<PunishmentModel> punishments = service.getByPlayerId(Mockito.anyLong());
			Assertions.assertNull(punishments);
	    });
		Mockito.verify(repository, Mockito.times(1)).findByPlayerId(Mockito.anyLong());
	}

}
