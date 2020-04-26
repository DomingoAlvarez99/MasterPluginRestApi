package org.masterserver.service;

import java.util.List;

public interface CommonService<T> {
	
	List<T> getAll();
	T getById(long id);
	T create(T object);
	T update(long id, T object);
	void delete(long id);
	
}
