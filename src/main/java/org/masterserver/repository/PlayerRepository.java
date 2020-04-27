package org.masterserver.repository;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.masterserver.model.PlayerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<PlayerModel, Long> {
	
	Optional<PlayerModel> findByUuid(String uuid);
	Optional<PlayerModel> findByName(String name);
	List<PlayerModel> findByPrefix(String prefix);
	List<PlayerModel> findByNameColor(String name);
	List<PlayerModel> findByNameFormat(String nameFormat);
	List<PlayerModel> findByPrefixColor(String prefixColor);
	List<PlayerModel> findByPrefixFormat(String prefixFormat);
	List<PlayerModel> findByFirstLogin(Calendar firstLogin);
	List<PlayerModel> findByLastLogin(Calendar lastLogin);
	List<PlayerModel> findByTimePlayed(long timePlayed);
	
}
