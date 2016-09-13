package com.rest.omei.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.omei.entity.Pedido;
import com.rest.omei.serviceinterface.PedidoManager;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

	private PedidoManager pedidoManager;
	
	@Autowired
	public PedidoController(PedidoManager pedidoManager){
		this.pedidoManager = pedidoManager;
	}
	
	@GetMapping
	public List<Pedido> getAllPedidos(){
		return pedidoManager.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pedido> getPedido(@PathVariable("id")Long id){
		Pedido pedido = pedidoManager.findById(id);
		if(pedido==null)
			return new ResponseEntity<Pedido>(pedido,HttpStatus.NOT_FOUND);
		return new ResponseEntity<Pedido>(pedido,HttpStatus.OK);
	}
	
	@PostMapping
	public void createCategoria(@RequestBody Pedido pedido){
		pedidoManager.insert(pedido);
	}
}
