package com.rest.omei.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.omei.entity.Mesa;
import com.rest.omei.serviceinterface.MesaManager;

@RestController
@RequestMapping("/mesa")
public class MesaController {

	private MesaManager mesaManager;

	@Autowired
	public MesaController(MesaManager mesaManager) {
		this.mesaManager = mesaManager;
	}
	
	@GetMapping
	public List<Mesa> getAllMesas() {
		return mesaManager.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Mesa> getMesa(@PathVariable Long id) {
		Mesa mesa = mesaManager.findById(id);
		if (mesa == null)
			return new ResponseEntity<Mesa>(mesa, HttpStatus.NOT_FOUND);
		return new ResponseEntity<Mesa>(mesa, HttpStatus.OK);
	}

}
