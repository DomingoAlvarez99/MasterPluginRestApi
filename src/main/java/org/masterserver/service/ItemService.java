package org.masterserver.service;

import java.util.List;

import org.masterserver.model.ItemModel;

public interface ItemService extends CommonService<ItemModel> {

	ItemModel findByUuid(long uuid);
	List<ItemModel> findByDurability(long durability);
	ItemModel findByName(String name);
	List<ItemModel> findByType(String type);
	
}