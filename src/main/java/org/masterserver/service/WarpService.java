package org.masterserver.service;

import java.util.List;

import org.masterserver.model.WarpModel;

public interface WarpService extends CommonService<WarpModel> {

	List<WarpModel> findByName(String name);
	List<WarpModel> findByCoordinateX(long coordinateX);
	List<WarpModel> findByCoordinateY(long coordinateY);
	List<WarpModel> findByCoordinateZ(long coordinateZ);
	List<WarpModel> findByPlayerId(long playerId);
	
}