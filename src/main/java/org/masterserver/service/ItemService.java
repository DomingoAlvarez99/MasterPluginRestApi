package org.masterserver.service;

import java.util.List;

import org.masterserver.model.ItemModel;

public interface ItemService extends CommonService<ItemModel> {

	ItemModel getByUuid(long uuid);
	List<ItemModel> getByDurability(long durability);
	ItemModel getByName(String name);
	List<ItemModel> getByType(String type);
	
}