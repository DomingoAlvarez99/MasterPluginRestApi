package org.masterserver.service;

import java.util.Calendar;
import java.util.List;

import org.masterserver.model.DeathModel;

public interface DeathService extends CommonService<DeathModel> {

	List<DeathModel> getByDate(Calendar date);
	List<DeathModel> getByCause(String cause);
	List<DeathModel> getByMobId(long mobId);
	List<DeathModel> getByAssasinId(long assasinId);
	List<DeathModel> getByMurderedId(long murderedId);
	
}