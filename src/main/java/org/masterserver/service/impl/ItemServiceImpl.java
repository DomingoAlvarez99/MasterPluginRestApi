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
		List<ItemModel> items = repository.findAll();
		if (items.isEmpty()) {
			throw new ResourceNotFoundException("Items not found.");
		}
		return items;
	}

	@Override
	public ItemModel getById(long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found, couldn't get item."));
	}

	@Override
	public ItemModel create(ItemModel object) {
		return repository.save(object);
	}

	@Override
	public ItemModel update(long id, ItemModel commandModel) {
		repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found, couldn't update item."));
		commandModel.setId(id);
		return repository.save(commandModel);
	}

	@Override
	public boolean delete(long id) {
		repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found, couldn't delete item."));
		repository.deleteById(id);
		return true;
	}

	@Override
	public ItemModel getByUuid(long uuid) {
		return repository.findByUuid(uuid).orElseThrow(() -> new ResourceNotFoundException("Uuid not found, couldn't get item."));
	}

	@Override
	public List<ItemModel> getByDurability(long durability) {
		List<ItemModel> items = repository.findByDurability(durability);
		if (items.isEmpty()) {
			throw new ResourceNotFoundException("Durability not found, couldn't get items.");
		}
		return items;
	}

	@Override
	public ItemModel getByName(String name) {
		return repository.findByName(name).orElseThrow(() -> new ResourceNotFoundException("Name not found, couldn't get item."));
	}

	@Override
	public List<ItemModel> getByType(String type) {
		List<ItemModel> items = repository.findByType(type);
		if (items.isEmpty()) {
			throw new ResourceNotFoundException("Type not found, couldn't get items.");
		}
		return items;
	}
	
}