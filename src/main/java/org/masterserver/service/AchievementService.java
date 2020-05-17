package org.masterserver.service;

import java.util.List;

import org.masterserver.model.AchievementModel;

public interface AchievementService extends CommonService<AchievementModel> {

	List<AchievementModel> getByName(String name);
	
}
