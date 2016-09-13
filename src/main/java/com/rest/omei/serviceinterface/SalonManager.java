package com.rest.omei.serviceinterface;

import java.util.List;

import com.rest.omei.entity.Salon;

public interface SalonManager {
	public void insert(Salon salon);
	public void update(Salon salon);
	public void delete(Salon salon);
	public List<Salon> findAll();
	public Salon findById(Long key);
}
