package com.rest.omei.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.omei.daointerface.DetallePedidoDAO;
import com.rest.omei.daointerface.PedidoDAO;
import com.rest.omei.entity.Pedido;
import com.rest.omei.serviceinterface.PedidoManager;

@Service
public class PedidoManagerImpl implements PedidoManager {

	private PedidoDAO pedidoDAO;
	private DetallePedidoDAO detallePedidoDAO;

	@Autowired
	public PedidoManagerImpl(PedidoDAO pedidoDAO, DetallePedidoDAO detallePedidoDAO) {
		this.pedidoDAO = pedidoDAO;
		this.detallePedidoDAO = detallePedidoDAO;
	}

	@Override
	public void insert(Pedido pedido) {
		pedidoDAO.insert(pedido);
		pedido.getDetallePedido().forEach(detalle -> detallePedidoDAO.insert(detalle));
	}

	@Override
	public void update(Pedido pedido) {
		pedidoDAO.update(pedido);
	}

	@Override
	public void delete(Pedido pedido) {
		pedidoDAO.delete(pedido);
	}

	@Override
	public List<Pedido> findAll() {
		return pedidoDAO.findAll();
	}

	@Override
	public Pedido findById(Long key) {
		return pedidoDAO.findById(key);
	}

}
