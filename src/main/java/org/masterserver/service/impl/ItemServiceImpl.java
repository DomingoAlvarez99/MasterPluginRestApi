package org.masterserver.service.impl;

import java.util.List;

import org.masterserver.exception.ResourceNotFoundException;
import org.masterserver.model.ItemModel;
import org.masterserver.repository.ItemRepository;
import org.masterserver.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository repository;

	@Override
	public List<ItemModel> getAll() {
		return repository.findAll();
	}

	@Override
	public ItemModel getById(long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Item not found."));
	}

	@Override
	public ItemModel create(ItemModel object) {
		return repository.save(object);
	}

	@Override
	public ItemModel update(long id, ItemModel commandModel) {
		repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Item not found, can't update the item."));
		commandModel.setId(id);
		return repository.save(commandModel);
	}

	@Override
	public void delete(long id) {
		repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Item not found, can't delete the item."));
		repository.deleteById(id);
	}

	@Override
	public ItemModel findByUuid(long uuid) {
		return repository.findByUuid(uuid).orElseThrow(() -> new ResourceNotFoundException("Item not found"));
	}

	@Override
	public List<ItemModel> findByDurability(long durability) {
		return repository.findByDurability(durability);
	}

	@Override
	public ItemModel findByName(String name) {
		return repository.findByName(name).orElseThrow(() -> new ResourceNotFoundException("Item not found"));
	}

	@Override
	public List<ItemModel> findByType(String type) {
		return repository.findByType(type);
	}
	
}