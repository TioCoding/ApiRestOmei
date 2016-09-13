package com.rest.omei.daointerface;

import java.util.List;

public interface GenericDAO<T,K> {
	public void insert(T t);
	public void update(T t);
	public void delete(T t);
	public List<T> findAll();
	public T findById(K k);
}
