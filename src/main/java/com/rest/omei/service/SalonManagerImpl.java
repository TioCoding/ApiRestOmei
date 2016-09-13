package com.rest.omei.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.omei.daointerface.SalonDAO;
import com.rest.omei.entity.Salon;
import com.rest.omei.serviceinterface.SalonManager;

@Service
public class SalonManagerImpl implements SalonManager{

	private SalonDAO salonDAO;
	
	@Autowired
	public SalonManagerImpl(SalonDAO salonDAO){
		this.salonDAO = salonDAO;
	}
	
	@Override
	public void insert(Salon salon) {
		salonDAO.insert(salon);
	}

	@Override
	public void update(Salon salon) {
		salonDAO.update(salon);
	}

	@Override
	public void delete(Salon salon) {
		salonDAO.delete(salon);
	}

	@Override
	public List<Salon> findAll() {
		return salonDAO.findAll();
	}

	@Override
	public Salon findById(Long key) {
		return salonDAO.findById(key);
	}
	
}
