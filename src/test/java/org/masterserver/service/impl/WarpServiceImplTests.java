package org.masterserver.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.masterserver.exception.ResourceNotFoundException;
import org.masterserver.model.WarpModel;
import org.masterserver.repository.WarpRepository;
import org.masterserver.service.WarpServiceTests;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class WarpServiceImplTests implements WarpServiceTests {

	@Mock
	private WarpRepository repository;
	
	@InjectMocks
	private WarpServiceImpl service;
	
	@BeforeEach
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	@Override
	public void getAll() {
		Mockito.when(repository.findAll()).thenReturn(new ArrayList<WarpModel>());
		Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			List<WarpModel> warps = service.getAll();
			Assertions.assertNull(warps);
	    });
		Mockito.verify(repository, Mockito.times(1)).findAll();
	}

	@Test
	@Override
	public void getById() {
		WarpModel warp = new WarpModel(1l, "home", -12,  -12l, -12l, 12l);
		Mockito.when(repository.findById(Mockito.anyLong())).thenReturn(Optional.of(warp));
		WarpModel result = service.getById(Mockito.anyLong());
		Assertions.assertEquals(1l, result.getId());
		Assertions.assertEquals("home", result.getName());
		Assertions.assertEquals(-12, result.getCoordinateX());
		Assertions.assertEquals(-12l, result.getCoordinateY());
		Assertions.assertEquals(-12l, result.getCoordinateX());
		Assertions.assertEquals(12l, result.getPlayerId());
		Mockito.verify(repository, Mockito.times(1)).findById(Mockito.anyLong());
	}

	@Test
	@Override
	public void create() {
		WarpModel warp = new WarpModel(1l, "home", -12,  -12l,  -12l, 12l);
		Mockito.when(repository.save(warp)).thenReturn(warp);
		WarpModel result = service.create(warp);
		Assertions.assertEquals(1l, result.getId());
		Assertions.assertEquals("home", result.getName());
		Assertions.assertEquals(-12, result.getCoordinateX());
		Assertions.assertEquals(-12l, result.getCoordinateY());
		Assertions.assertEquals(-12l, result.getCoordinateX());
		Assertions.assertEquals(12l, result.getPlayerId());
		Mockito.verify(repository, Mockito.times(1)).save(warp);
	}

	@Test
	@Override
	public void update() {
		WarpModel warp = new WarpModel(1l, "home", -12,  -12l,  -12l, 12l);
		Mockito.when(repository.save(warp)).thenReturn(warp);
		Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			service.update(1l, warp);
	    });
		Mockito.verify(repository, Mockito.times(1)).findById(Mockito.anyLong());
		Mockito.verify(repository, Mockito.times(0)).save(warp);
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
	public void getByName() {
		Mockito.when(repository.findByName((Mockito.anyString()))).thenReturn(new ArrayList<WarpModel>());
		Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			List<WarpModel> warps = service.getByName(Mockito.anyString());
			Assertions.assertNull(warps);
	    });
		Mockito.verify(repository, Mockito.times(1)).findByName(Mockito.anyString());
	}

	@Test
	@Override
	public void getByCoordinateX() {
		Mockito.when(repository.findByCoordinateX((Mockito.anyLong()))).thenReturn(new ArrayList<WarpModel>());
		Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			List<WarpModel> warps = service.getByCoordinateX(Mockito.anyLong());
			Assertions.assertNull(warps);
	    });
		Mockito.verify(repository, Mockito.times(1)).findByCoordinateX(Mockito.anyLong());
	}

	@Test
	@Override
	public void getByCoordinateY() {
		Mockito.when(repository.findByCoordinateY((Mockito.anyLong()))).thenReturn(new ArrayList<WarpModel>());
		Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			List<WarpModel> warps = service.getByCoordinateY(Mockito.anyLong());
			Assertions.assertNull(warps);
	    });
		Mockito.verify(repository, Mockito.times(1)).findByCoordinateY(Mockito.anyLong());
	}

	@Test
	@Override
	public void getByCoordinateZ() {
		Mockito.when(repository.findByCoordinateZ((Mockito.anyLong()))).thenReturn(new ArrayList<WarpModel>());
		Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			List<WarpModel> warps = service.getByCoordinateZ(Mockito.anyLong());
			Assertions.assertNull(warps);
	    });
		Mockito.verify(repository, Mockito.times(1)).findByCoordinateZ(Mockito.anyLong());
	}

	@Test
	@Override
	public void getByPlayerId() {
		Mockito.when(repository.findByPlayerId((Mockito.anyLong()))).thenReturn(new ArrayList<WarpModel>());
		Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			List<WarpModel> warps = service.getByPlayerId(Mockito.anyLong());
			Assertions.assertNull(warps);
	    });
		Mockito.verify(repository, Mockito.times(1)).findByPlayerId(Mockito.anyLong());
	}

}
