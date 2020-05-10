package org.masterserver.service;

import org.masterserver.model.PermissionModel;

public interface PermissionService extends CommonService<PermissionModel> {

	PermissionModel getByName(String name);
	
}
