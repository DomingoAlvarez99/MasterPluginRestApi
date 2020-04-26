package org.masterserver.repository;

import java.util.List;

import org.masterserver.model.PlayerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<PlayerModel, Long> {
	
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
