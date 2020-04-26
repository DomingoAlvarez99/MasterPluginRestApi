package org.masterserver.repository;

import java.util.List;

import org.masterserver.model.ItemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<ItemModel, Long> {
	
	ItemModel findByUuid(long uuid);
	List<ItemModel> findByDurability(long durability);
	ItemModel findByName(String name);
	List<ItemModel> findByType(String type);
	
}
