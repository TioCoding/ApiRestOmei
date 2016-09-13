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

import com.rest.omei.entity.Categoria;
import com.rest.omei.serviceinterface.CategoriaManager;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	
	private CategoriaManager categoriaManager;
	
	@Autowired
	public CategoriaController(CategoriaManager categoriaManager){
		this.categoriaManager = categoriaManager;
	}
	
	@GetMapping
	public List<Categoria> getAllCategorias(){
		return categoriaManager.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> getCategoria(@PathVariable("id")Long id){
		Categoria categoria = categoriaManager.findById(id);
		if(categoria==null)
			return new ResponseEntity<Categoria>(categoria,HttpStatus.NOT_FOUND);
		return new ResponseEntity<Categoria>(categoria,HttpStatus.OK);
	}
	
	@PostMapping
	public void createCategoria(@RequestBody Categoria categoria){
		categoriaManager.insert(categoria);
	}
	
}
