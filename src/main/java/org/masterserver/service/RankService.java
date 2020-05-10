package org.masterserver.service;

import org.masterserver.model.RankModel;

public interface RankService extends CommonService<RankModel> {

	RankModel getByName(String name);
	
}