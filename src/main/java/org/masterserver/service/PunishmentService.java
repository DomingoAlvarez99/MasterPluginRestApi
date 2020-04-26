package org.masterserver.service;

import java.util.Calendar;
import java.util.List;

import org.masterserver.model.PunishmentModel;

public interface PunishmentService extends CommonService<PunishmentModel> {

	List<PunishmentModel> findByDate(Calendar date);
	List<PunishmentModel> findByType(String type);
	List<PunishmentModel> findByDescription(String type);
	List<PunishmentModel> findByPlayerId(long playerId);
	
}