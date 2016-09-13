package com.rest.omei.daointerface;

import java.util.List;

import com.rest.omei.entity.Plato;

public interface PlatoDAO extends GenericDAO<Plato, Long>{
	public List<Plato> findAllWhitCategoria ();
}
