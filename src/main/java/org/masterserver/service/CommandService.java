package org.masterserver.service;

import java.util.Calendar;
import java.util.List;

import org.masterserver.model.CommandModel;

public interface CommandService extends CommonService<CommandModel> {

	List<CommandModel> findByPlayerId(long playerId);
	List<CommandModel> findByCommand(String command);
	List<CommandModel> findByDate(Calendar date);
	
}