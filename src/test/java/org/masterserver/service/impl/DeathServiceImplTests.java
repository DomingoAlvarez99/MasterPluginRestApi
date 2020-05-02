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
import org.masterserver.model.DeathModel;
import org.masterserver.repository.DeathRepository;
import org.masterserver.service.DeathServiceTests;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class DeathServiceImplTests implements DeathServiceTests {

	@Mock
	private DeathRepository repository;
	
	@InjectMocks
	private DeathServiceImpl service;
	
	@BeforeEach
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	@Override
	public void getAll() {
		Mockito.when(repository.findAll()).thenReturn(new ArrayList<DeathModel>());
		Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			List<DeathModel> deaths = service.getAll();
			Assertions.assertNull(deaths);
	    });
		Mockito.verify(repository, Mockito.times(1)).findAll();
	}

	@Test
	@Override
	public void getById() {
		DeathModel death = new DeathModel(1l, Calendar.getInstance(Locale.GERMANY), "fire", 0l, 1l, 0l);
		Mockito.when(repository.findById(Mockito.anyLong())).thenReturn(Optional.of(death));
		DeathModel result = service.getById(Mockito.anyLong());
		Assertions.assertEquals(1l, result.getId());
		Assertions.assertNotNull(result.getDate());
		Assertions.assertEquals("fire", result.getCause());
		Assertions.assertEquals(0l, result.getMobId());
		Assertions.assertEquals(1l, result.getAssasinId());
		Assertions.assertEquals(0l, result.getMurderedId());
		Mockito.verify(repository, Mockito.times(1)).findById(Mockito.anyLong());
	}

	@Test
	@Override
	public void create() {
		DeathModel death = new DeathModel(1l, Calendar.getInstance(Locale.GERMANY), "fire", 0l, 1l, 0l);
		Mockito.when(repository.save(death)).thenReturn(death);
		DeathModel result = service.create(death);
		Assertions.assertEquals(1l, result.getId());
		Assertions.assertNotNull(result.getDate());
		Assertions.assertEquals("fire", result.getCause());
		Assertions.assertEquals(0l, result.getMobId());
		Assertions.assertEquals(1l, result.getAssasinId());
		Assertions.assertEquals(0l, result.getMurderedId());
		Mockito.verify(repository, Mockito.times(1)).save(death);
	}

	@Test
	@Override
	public void update() {
		DeathModel death = new DeathModel(1l, Calendar.getInstance(Locale.GERMANY), "fire", 0l, 1l, 0l);
		Mockito.when(repository.save(death)).thenReturn(death);
		Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			service.update(1l, death);
	    });
		Mockito.verify(repository, Mockito.times(1)).findById(Mockito.anyLong());
		Mockito.verify(repository, Mockito.times(0)).save(death);
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
	public void getByDate() {
		Mockito.when(repository.findByDate((Mockito.any()))).thenReturn(new ArrayList<DeathModel>());
		Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			List<DeathModel> deaths = service.getByDate(Mockito.any());
			Assertions.assertNull(deaths);
	    });
		Mockito.verify(repository, Mockito.times(1)).findByDate(Mockito.any());
	}

	@Test
	@Override
	public void getByCause() {
		Mockito.when(repository.findByCause((Mockito.anyString()))).thenReturn(new ArrayList<DeathModel>());
		Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			List<DeathModel> deaths = service.getByCause(Mockito.anyString());
			Assertions.assertNull(deaths);
	    });
		Mockito.verify(repository, Mockito.times(1)).findByCause(Mockito.anyString());
	}

	@Test
	@Override
	public void getByMobId() {
		Mockito.when(repository.findByMobId((Mockito.anyLong()))).thenReturn(new ArrayList<DeathModel>());
		Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			List<DeathModel> deaths = service.getByMobId(Mockito.anyLong());
			Assertions.assertNull(deaths);
	    });
		Mockito.verify(repository, Mockito.times(1)).findByMobId(Mockito.anyLong());
	}

	@Test
	@Override
	public void getByAssasinId() {
		Mockito.when(repository.findByAssasinId((Mockito.anyLong()))).thenReturn(new ArrayList<DeathModel>());
		Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			List<DeathModel> deaths = service.getByAssasinId(Mockito.anyLong());
			Assertions.assertNull(deaths);
	    });
		Mockito.verify(repository, Mockito.times(1)).findByAssasinId(Mockito.anyLong());
	}
	
	@Test
	@Override
	public void getByMurderedId() {
		Mockito.when(repository.findByMurderedId((Mockito.anyLong()))).thenReturn(new ArrayList<DeathModel>());
		Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			List<DeathModel> deaths = service.getByMurderedId(Mockito.anyLong());
			Assertions.assertNull(deaths);
	    });
		Mockito.verify(repository, Mockito.times(1)).findByMurderedId(Mockito.anyLong());
	}

}
