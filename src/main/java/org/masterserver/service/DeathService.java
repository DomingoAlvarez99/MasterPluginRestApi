package org.masterserver.service;

import java.util.List;

import org.masterserver.model.DeathModel;

public interface DeathService extends CommonService<DeathModel> {

	List<DeathModel> getByCause(String cause);
	
}