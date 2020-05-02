package org.masterserver.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.masterserver.exception.ResourceNotFoundException;
import org.masterserver.model.ItemModel;
import org.masterserver.repository.ItemRepository;
import org.masterserver.service.ItemServiceTests;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class ItemServiceImplTests implements ItemServiceTests {

	@Mock
	private ItemRepository repository;
	
	@InjectMocks
	private ItemServiceImpl service;
	
	@BeforeEach
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	@Override
	public void getAll() {
		Mockito.when(repository.findAll()).thenReturn(new ArrayList<ItemModel>());
		Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			List<ItemModel> items = service.getAll();
			Assertions.assertNull(items);
	    });
		Mockito.verify(repository, Mockito.times(1)).findAll();
	}

	@Test
	@Override
	public void getById() {
		ItemModel item = new ItemModel(1l, 1l, 1l, "granite", "stone");
		Mockito.when(repository.findById(Mockito.anyLong())).thenReturn(Optional.of(item));
		ItemModel result = service.getById(Mockito.anyLong());
		Assertions.assertEquals(1l, result.getId());
		Assertions.assertEquals(1l, result.getUuid());
		Assertions.assertEquals(1l, result.getDurability());
		Assertions.assertEquals("granite", result.getName());
		Assertions.assertEquals("stone", result.getType());
		Mockito.verify(repository, Mockito.times(1)).findById(Mockito.anyLong());
	}

	@Test
	@Override
	public void create() {
		ItemModel item = new ItemModel(1l, 1l, 1l, "granite", "stone");
		Mockito.when(repository.save(item)).thenReturn(item);
		ItemModel result = service.create(item);
		Assertions.assertEquals(1l, result.getId());
		Assertions.assertEquals(1l, result.getUuid());
		Assertions.assertEquals(1l, result.getDurability());
		Assertions.assertEquals("granite", result.getName());
		Assertions.assertEquals("stone", result.getType());
		Mockito.verify(repository, Mockito.times(1)).save(item);
	}

	@Test
	@Override
	public void update() {
		ItemModel item = new ItemModel(1l, 1l, 1l, "granite", "stone");
		Mockito.when(repository.save(item)).thenReturn(item);
		Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			service.update(1l, item);
	    });
		Mockito.verify(repository, Mockito.times(1)).findById(Mockito.anyLong());
		Mockito.verify(repository, Mockito.times(0)).save(item);
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
	public void getByUuid() {
		Mockito.when(repository.findByUuid(Mockito.anyLong())).thenReturn(Optional.of(new ItemModel(1l, 1l, 1l, "granite", "stone")));
		ItemModel result = service.getByUuid(Mockito.anyLong());
		Assertions.assertEquals(1l, result.getId());
		Assertions.assertEquals(1l, result.getUuid());
		Assertions.assertEquals(1l, result.getDurability());
		Assertions.assertEquals("granite", result.getName());
		Assertions.assertEquals("stone", result.getType());
		Mockito.verify(repository, Mockito.times(1)).findByUuid(Mockito.anyLong());
	}

	@Test
	@Override
	public void getByDurability() {
		Mockito.when(repository.findByDurability(Mockito.anyLong())).thenReturn(new ArrayList<ItemModel>());
		Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			List<ItemModel> items = service.getByDurability(Mockito.anyLong());
			Assertions.assertNull(items);
	    });
		Mockito.verify(repository, Mockito.times(1)).findByDurability(Mockito.anyLong());
	}
	
	@Test
	@Override
	public void getByName() {
		Mockito.when(repository.findByName(Mockito.anyString())).thenReturn(Optional.of(new ItemModel(1l, 1l, 1l, "granite", "stone")));
		ItemModel result = service.getByName(Mockito.anyString());
		Assertions.assertEquals(1l, result.getId());
		Assertions.assertEquals(1l, result.getUuid());
		Assertions.assertEquals(1l, result.getDurability());
		Assertions.assertEquals("granite", result.getName());
		Assertions.assertEquals("stone", result.getType());
		Mockito.verify(repository, Mockito.times(1)).findByName(Mockito.anyString());
	}
	
	@Test
	@Override
	public void getByType() {
		Mockito.when(repository.findByType((Mockito.anyString()))).thenReturn(new ArrayList<ItemModel>());
		Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			List<ItemModel> items = service.getByType(Mockito.anyString());
			Assertions.assertNull(items);
	    });
		Mockito.verify(repository, Mockito.times(1)).findByType(Mockito.anyString());
	}

}