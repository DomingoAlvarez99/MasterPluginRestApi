package org.masterserver.service.impl;

import java.util.List;

import org.masterserver.model.ItemModel;
import org.masterserver.repository.ItemRepository;
import org.masterserver.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository repository;

	@Override
	public List<ItemModel> getAll() {
		List<ItemModel> items = repository.findAll();
		if (items.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Items not found.");
		}
		return items;
	}

	@Override
	public ItemModel getById(long id) {
		return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Id {" + id + "} not found, couldn't get item."));
	}

	@Override
	public ItemModel create(ItemModel item) {
		if (repository.findByName(item.getName()).isPresent()) {
			throw new ResponseStatusException(HttpStatus.CONFLICT,
					"Name {" + item.getName() + "} exists, couldn't create item.");
		}
		return repository.save(item);
	}

	@Override
	public ItemModel update(long id, ItemModel item) {
		repository.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Id not found, couldn't update item."));
		if (repository.findByName(item.getName()).isPresent()
				&& repository.findByName(item.getName()).get().getId() != id) {
			throw new ResponseStatusException(HttpStatus.CONFLICT,
					"Name {" + item.getName() + "} exists, couldn't update item.");
		}
		item.setId(id);
		return repository.save(item);
	}

	@Override
	public boolean delete(long id) {
		repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Id {" + id + "} not found, couldn't delete item."));
		repository.deleteById(id);
		return true;
	}

	@Override
	public ItemModel getByUuid(long uuid) {
		return repository.findByUuid(uuid).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Uuid {" + uuid + "} not found, couldn't get item."));
	}

	@Override
	public List<ItemModel> getByDurability(long durability) {
		List<ItemModel> items = repository.findByDurability(durability);
		if (items.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Durability {" + durability + "} not found, couldn't get items.");
		}
		return items;
	}

	@Override
	public ItemModel getByName(String name) {
		return repository.findByName(name).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Name {" + name + "} not found, couldn't get item."));
	}

	@Override
	public List<ItemModel> getByType(String type) {
		List<ItemModel> items = repository.findByType(type);
		if (items.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Type {" + type + "} not found, couldn't get items.");
		}
		return items;
	}

}