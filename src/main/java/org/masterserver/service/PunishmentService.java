package org.masterserver.service;

import java.util.Calendar;
import java.util.List;

import org.masterserver.model.PunishmentModel;

public interface PunishmentService extends CommonService<PunishmentModel> {

	List<PunishmentModel> getByDate(Calendar date);
	List<PunishmentModel> getByType(String type);
	List<PunishmentModel> getByDescription(String type);
	List<PunishmentModel> getByPlayerId(long playerId);
	
}