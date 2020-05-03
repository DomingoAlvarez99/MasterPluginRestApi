package org.masterserver.service.impl;

import java.util.List;

import org.masterserver.exception.ResourceExistsException;
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
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id {" + id + "} not found, couldn't get item."));
	}

	@Override
	public ItemModel create(ItemModel item) {
		if (repository.findByName(item.getName()).isPresent()) {
			throw new ResourceExistsException("Name {" + item.getName() + "} exists, couldn't create item.");
		}
		if (repository.findByUuid(item.getUuid()).isPresent()) {
			throw new ResourceExistsException("Uuid {" + item.getUuid() + "} exists, couldn't create item.");
		}
		return repository.save(item);
	}

	@Override
	public ItemModel update(long id, ItemModel item) {
		repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found, couldn't update item."));
		if (repository.findByName(item.getName()).isPresent()) {
			throw new ResourceExistsException("Name {" + item.getName() + "} exists, couldn't create item.");
		}
		if (repository.findByUuid(item.getUuid()).isPresent()) {
			throw new ResourceExistsException("Uuid {" + item.getUuid() + "} exists, couldn't create item.");
		}
		item.setId(id);
		return repository.save(item);
	}

	@Override
	public boolean delete(long id) {
		repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id {" + id + "} not found, couldn't delete item."));
		repository.deleteById(id);
		return true;
	}

	@Override
	public ItemModel getByUuid(long uuid) {
		return repository.findByUuid(uuid).orElseThrow(() -> new ResourceNotFoundException("Uuid {" + uuid + "} not found, couldn't get item."));
	}

	@Override
	public List<ItemModel> getByDurability(long durability) {
		List<ItemModel> items = repository.findByDurability(durability);
		if (items.isEmpty()) {
			throw new ResourceNotFoundException("Durability {" + durability + "} not found, couldn't get items.");
		}
		return items;
	}

	@Override
	public ItemModel getByName(String name) {
		return repository.findByName(name).orElseThrow(() -> new ResourceNotFoundException("Name {" + name + "} not found, couldn't get item."));
	}

	@Override
	public List<ItemModel> getByType(String type) {
		List<ItemModel> items = repository.findByType(type);
		if (items.isEmpty()) {
			throw new ResourceNotFoundException("Type {" + type + "} not found, couldn't get items.");
		}
		return items;
	}
	
}