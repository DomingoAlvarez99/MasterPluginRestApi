package org.masterserver.repository;

import java.util.Calendar;
import java.util.List;

import org.masterserver.model.CommandModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandRepository extends JpaRepository<CommandModel, Long> {
	
	List<CommandModel> findByPlayerId(long playerId);
	List<CommandModel> findByCommand(String command);
	List<CommandModel> findByDate(Calendar date);
	
}
