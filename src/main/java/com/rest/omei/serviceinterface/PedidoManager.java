package com.rest.omei.serviceinterface;

import java.util.List;

import com.rest.omei.entity.Pedido;

public interface PedidoManager {
	public void insert(Pedido pedido);
	public void update(Pedido pedido);
	public void delete(Pedido pedido);
	public List<Pedido> findAll();
	public Pedido findById(Long key);
}
