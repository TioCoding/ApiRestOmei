package com.rest.omei.serviceinterface;

import java.util.List;

import com.rest.omei.entity.Categoria;

public interface CategoriaManager {
	public void insert(Categoria categoria);
	public void update(Categoria categoria);
	public void delete(Categoria categoria);
	public List<Categoria> findAll();
	public Categoria findById(Long key);
}
