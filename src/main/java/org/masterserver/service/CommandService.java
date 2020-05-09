package org.masterserver.service;

import java.util.List;

import org.masterserver.model.CommandModel;

public interface CommandService extends CommonService<CommandModel> {

	List<CommandModel> getByCommand(String command);
	
}