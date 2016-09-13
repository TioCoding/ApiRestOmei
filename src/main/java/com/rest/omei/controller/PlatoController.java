package com.rest.omei.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.omei.entity.Plato;
import com.rest.omei.serviceinterface.PlatoManager;

@RestController
@RequestMapping("/plato")
public class PlatoController {

	private PlatoManager platoManager;
	
	@Autowired
	public PlatoController(PlatoManager platoManager){
		this.platoManager = platoManager;
	}
	
	@GetMapping
	public List<Plato> getAllPlatos(){
		return platoManager.findAll();
	}
	
	@GetMapping("/categoria")
	public List<Plato> getAllPlatosWithCategoria(){
		return platoManager.findAllWithCategoria();
	}
}
