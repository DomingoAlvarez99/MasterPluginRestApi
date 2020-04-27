package org.masterserver.service;

import java.util.Calendar;
import java.util.List;

import org.masterserver.model.CommandModel;

public interface CommandService extends CommonService<CommandModel> {

	List<CommandModel> getByPlayerId(long playerId);
	List<CommandModel> getByCommand(String command);
	List<CommandModel> getByDate(Calendar date);
	
}