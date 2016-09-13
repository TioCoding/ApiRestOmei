package com.rest.omei.serviceinterface;

import java.util.List;

import com.rest.omei.entity.Mesa;

public interface MesaManager {
	public void insert(Mesa mesa);
	public void update(Mesa mesa);
	public void delete(Mesa mesa);
	public List<Mesa> findAll();
	public Mesa findById(Long key);
}
