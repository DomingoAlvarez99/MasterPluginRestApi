package org.masterserver.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.masterserver.model.PlayerModel;
import org.masterserver.repository.PlayerRepository;
import org.masterserver.service.PlayerServiceTests;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.web.server.ResponseStatusException;

public class PlayerServiceImplTests implements PlayerServiceTests {

	@Mock
	private PlayerRepository repository;

	@InjectMocks
	private PlayerServiceImpl service;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	@Override
	public void getAll() {
		Mockito.when(repository.findAll()).thenReturn(new ArrayList<PlayerModel>());
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			List<PlayerModel> players = service.getAll();
			Assertions.assertNull(players);
		});
		Mockito.verify(repository, Mockito.times(1)).findAll();
	}

	@Test
	@Override
	public void getById() {
		PlayerModel player = new PlayerModel(1l, "8c898aa3-b0fb-4695-82fc-a816a7a3c3ec", "Federico", "[Dev]", "&3",
				"&l", "&4", "&l", Calendar.getInstance(Locale.GERMAN), Calendar.getInstance(Locale.GERMAN), 1232312l,
				"17.212.1");
		Mockito.when(repository.findById(Mockito.anyLong())).thenReturn(Optional.of(player));
		PlayerModel result = service.getById(Mockito.anyLong());
		Assertions.assertEquals(1l, result.getId());
		Assertions.assertEquals("8c898aa3-b0fb-4695-82fc-a816a7a3c3ec", result.getUuid());
		Assertions.assertEquals("Federico", result.getName());
		Assertions.assertEquals("[Dev]", result.getPrefix());
		Assertions.assertEquals("&3", result.getNameColor());
		Assertions.assertEquals("&l", result.getNameFormat());
		Assertions.assertEquals("&4", result.getPrefixColor());
		Assertions.assertEquals("&l", result.getPrefixFormat());
		Assertions.assertNotNull(result.getFirstLogin());
		Assertions.assertNotNull(result.getLastLogin());
		Assertions.assertEquals(1232312l, result.getTimePlayed());
		Assertions.assertEquals("17.212.1", result.getIp());
		Mockito.verify(repository, Mockito.times(1)).findById(Mockito.anyLong());
	}

	@Test
	@Override
	public void create() {
		PlayerModel player = new PlayerModel(1l, "8c898aa3-b0fb-4695-82fc-a816a7a3c3ec", "Federico", "[Dev]", "&3",
				"&l", "&4", "&l", Calendar.getInstance(Locale.GERMAN), Calendar.getInstance(Locale.GERMAN), 1232312l,
				"17.212.1");
		Mockito.when(repository.save(player)).thenReturn(player);
		PlayerModel result = service.create(player);
		Assertions.assertEquals(1l, result.getId());
		Assertions.assertEquals("8c898aa3-b0fb-4695-82fc-a816a7a3c3ec", result.getUuid());
		Assertions.assertEquals("Federico", result.getName());
		Assertions.assertEquals("[Dev]", result.getPrefix());
		Assertions.assertEquals("&3", result.getNameColor());
		Assertions.assertEquals("&l", result.getNameFormat());
		Assertions.assertEquals("&4", result.getPrefixColor());
		Assertions.assertEquals("&l", result.getPrefixFormat());
		Assertions.assertNotNull(result.getFirstLogin());
		Assertions.assertNotNull(result.getLastLogin());
		Assertions.assertEquals(1232312l, result.getTimePlayed());
		Assertions.assertEquals("17.212.1", result.getIp());
		Mockito.verify(repository, Mockito.times(1)).save(player);
	}

	@Test
	@Override
	public void update() {
		PlayerModel player = new PlayerModel(1l, "8c898aa3-b0fb-4695-82fc-a816a7a3c3ec", "Federico", "[Dev]", "&3",
				"&l", "&4", "&l", Calendar.getInstance(Locale.GERMAN), Calendar.getInstance(Locale.GERMAN), 1232312l,
				"17.212.1");
		Mockito.when(repository.save(player)).thenReturn(player);
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			service.update(1l, player);
		});
		Mockito.verify(repository, Mockito.times(1)).findById(Mockito.anyLong());
		Mockito.verify(repository, Mockito.times(0)).save(player);
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
	public void getByUuid() {
		Mockito.when(repository.findByUuid(Mockito.anyString()))
				.thenReturn(Optional.of(new PlayerModel(1l, "8c898aa3-b0fb-4695-82fc-a816a7a3c3ec", "Federico", "[Dev]",
						"&3", "&l", "&4", "&l", Calendar.getInstance(Locale.GERMAN),
						Calendar.getInstance(Locale.GERMAN), 1232312l, "17.212.1")));
		PlayerModel result = service.getByUuid(Mockito.anyString());
		Assertions.assertEquals(1l, result.getId());
		Assertions.assertEquals("8c898aa3-b0fb-4695-82fc-a816a7a3c3ec", result.getUuid());
		Assertions.assertEquals("Federico", result.getName());
		Assertions.assertEquals("[Dev]", result.getPrefix());
		Assertions.assertEquals("&3", result.getNameColor());
		Assertions.assertEquals("&l", result.getNameFormat());
		Assertions.assertEquals("&4", result.getPrefixColor());
		Assertions.assertEquals("&l", result.getPrefixFormat());
		Assertions.assertNotNull(result.getFirstLogin());
		Assertions.assertNotNull(result.getLastLogin());
		Assertions.assertEquals(1232312l, result.getTimePlayed());
		Assertions.assertEquals("17.212.1", result.getIp());
		Mockito.verify(repository, Mockito.times(1)).findByUuid(Mockito.anyString());
	}
	
	@Test
	@Override
	public void getByName() {
		Mockito.when(repository.findByName(Mockito.anyString()))
				.thenReturn(Optional.of(new PlayerModel(1l, "8c898aa3-b0fb-4695-82fc-a816a7a3c3ec", "Federico", "[Dev]",
						"&3", "&l", "&4", "&l", Calendar.getInstance(Locale.GERMAN),
						Calendar.getInstance(Locale.GERMAN), 1232312l, "17.212.1")));
		PlayerModel result = service.getByName(Mockito.anyString());
		Assertions.assertEquals(1l, result.getId());
		Assertions.assertEquals("8c898aa3-b0fb-4695-82fc-a816a7a3c3ec", result.getUuid());
		Assertions.assertEquals("Federico", result.getName());
		Assertions.assertEquals("[Dev]", result.getPrefix());
		Assertions.assertEquals("&3", result.getNameColor());
		Assertions.assertEquals("&l", result.getNameFormat());
		Assertions.assertEquals("&4", result.getPrefixColor());
		Assertions.assertEquals("&l", result.getPrefixFormat());
		Assertions.assertNotNull(result.getFirstLogin());
		Assertions.assertNotNull(result.getLastLogin());
		Assertions.assertEquals(1232312l, result.getTimePlayed());
		Assertions.assertEquals("17.212.1", result.getIp());
		Mockito.verify(repository, Mockito.times(1)).findByName(Mockito.anyString());
	}

	@Test
	@Override
	public void getByPrefix() {
		Mockito.when(repository.findByPrefix((Mockito.anyString()))).thenReturn(new ArrayList<PlayerModel>());
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			List<PlayerModel> players = service.getByPrefix(Mockito.anyString());
			Assertions.assertNull(players);
		});
		Mockito.verify(repository, Mockito.times(1)).findByPrefix(Mockito.anyString());
	}

	@Test
	@Override
	public void getByNameColor() {
		Mockito.when(repository.findByNameColor((Mockito.anyString()))).thenReturn(new ArrayList<PlayerModel>());
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			List<PlayerModel> players = service.getByNameColor(Mockito.anyString());
			Assertions.assertNull(players);
		});
		Mockito.verify(repository, Mockito.times(1)).findByNameColor(Mockito.anyString());
	}

	@Test
	@Override
	public void getByNameFormat() {
		Mockito.when(repository.findByNameFormat((Mockito.anyString()))).thenReturn(new ArrayList<PlayerModel>());
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			List<PlayerModel> players = service.getByNameFormat(Mockito.anyString());
			Assertions.assertNull(players);
		});
		Mockito.verify(repository, Mockito.times(1)).findByNameFormat(Mockito.anyString());
	}

	@Test
	@Override
	public void getByPrefixColor() {
		Mockito.when(repository.findByPrefixColor((Mockito.anyString()))).thenReturn(new ArrayList<PlayerModel>());
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			List<PlayerModel> players = service.getByPrefixColor(Mockito.anyString());
			Assertions.assertNull(players);
		});
		Mockito.verify(repository, Mockito.times(1)).findByPrefixColor(Mockito.anyString());
	}

	@Test
	@Override
	public void getByPrefixFormat() {
		Mockito.when(repository.findByPrefixFormat((Mockito.anyString()))).thenReturn(new ArrayList<PlayerModel>());
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			List<PlayerModel> players = service.getByPrefixFormat(Mockito.anyString());
			Assertions.assertNull(players);
		});
		Mockito.verify(repository, Mockito.times(1)).findByPrefixFormat(Mockito.anyString());
	}

	@Test
	@Override
	public void getByTimePlayed() {
		Mockito.when(repository.findByTimePlayed((Mockito.anyLong()))).thenReturn(new ArrayList<PlayerModel>());
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			List<PlayerModel> players = service.getByTimePlayed(Mockito.anyLong());
			Assertions.assertNull(players);
		});
		Mockito.verify(repository, Mockito.times(1)).findByTimePlayed(Mockito.anyLong());

	}

}