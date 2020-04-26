package org.masterserver.service;

import java.util.List;

import org.masterserver.model.PlayerModel;

public interface PlayerService extends CommonService<PlayerModel> {

	PlayerModel findByUuid(String uuid);
	PlayerModel findByName(String name);
	List<PlayerModel> findByPrefix(String prefix);
	List<PlayerModel> findByNameColor(String name);
	List<PlayerModel> findByNameFormat(String nameFormat);
	List<PlayerModel> findByPrefixColor(String prefixColor);
	List<PlayerModel> findByPrefixFormat(String prefixFormat);
	List<PlayerModel> findByFirstLogin(String firstLogin);
	List<PlayerModel> findByLastLogin(String lastLogin);
	List<PlayerModel> findByTimePlayed(String timePlayed);
	
}