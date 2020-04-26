package org.masterserver.service;

import java.util.Calendar;
import java.util.List;

import org.masterserver.model.DeathModel;

public interface DeathService extends CommonService<DeathModel> {

	List<DeathModel> findByDate(Calendar date);
	List<DeathModel> findByCause(String cause);
	List<DeathModel> findByMobId(long mobId);
	List<DeathModel> findByAssasinId(long assasinId);
	List<DeathModel> findByMurderedId(long murderedId);
	
}