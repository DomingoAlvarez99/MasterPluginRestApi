package org.masterserver.service;

import java.util.List;

import org.masterserver.model.WarpModel;

public interface WarpService extends CommonService<WarpModel> {

	List<WarpModel> getByName(String name);
	List<WarpModel> getByCoordinateX(long coordinateX);
	List<WarpModel> getByCoordinateY(long coordinateY);
	List<WarpModel> getByCoordinateZ(long coordinateZ);
	
}