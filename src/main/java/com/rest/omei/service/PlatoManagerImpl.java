package com.rest.omei.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.omei.daointerface.PlatoDAO;
import com.rest.omei.entity.Plato;
import com.rest.omei.serviceinterface.PlatoManager;

@Service
public class PlatoManagerImpl implements PlatoManager{

	private PlatoDAO platoDAO;
	
	@Autowired
	public PlatoManagerImpl(PlatoDAO platoDAO){
		this.platoDAO = platoDAO;
	}
	
	@Override
	public void insert(Plato plato) {
		platoDAO.insert(plato);
	}

	@Override
	public void update(Plato plato) {
		platoDAO.update(plato);
	}

	@Override
	public void delete(Plato plato) {
		platoDAO.delete(plato);
	}

	@Override
	public List<Plato> findAll() {
		return platoDAO.findAll();
	}

	@Override
	public Plato findById(Long key) {
		return platoDAO.findById(key);
	}

	@Override
	public List<Plato> findAllWithCategoria() {
		return platoDAO.findAllWhitCategoria();
	}

}
