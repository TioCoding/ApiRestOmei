package com.rest.omei.serviceinterface;

import java.util.List;

import com.rest.omei.entity.Plato;

public interface PlatoManager {
	public void insert(Plato plato);
	public void update(Plato plato);
	public void delete(Plato plato);
	public List<Plato> findAll();
	public Plato findById(Long key);
	public List<Plato> findAllWithCategoria();
}
