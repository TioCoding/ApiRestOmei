package com.rest.omei.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rest.omei.daointerface.MesaDAO;
import com.rest.omei.entity.Mesa;
import com.rest.omei.serviceinterface.MesaManager;

@Service
public class MesaManagerImpl implements MesaManager {

	private MesaDAO mesaDAO;
	
	public MesaManagerImpl(MesaDAO mesaDAO){
		this.mesaDAO = mesaDAO;
	}
	
	@Override
	public void insert(Mesa mesa) {
		mesaDAO.insert(mesa);
	}

	@Override
	public void update(Mesa mesa) {
		mesaDAO.update(mesa);
	}

	@Override
	public void delete(Mesa mesa) {
		mesaDAO.delete(mesa);
	}

	@Override
	public List<Mesa> findAll() {
		return mesaDAO.findAll();
	}

	@Override
	public Mesa findById(Long key) {
		return mesaDAO.findById(key);
	}

}
