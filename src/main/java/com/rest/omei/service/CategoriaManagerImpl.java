package com.rest.omei.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.omei.daointerface.CategoriaDAO;
import com.rest.omei.entity.Categoria;
import com.rest.omei.serviceinterface.CategoriaManager;

@Service
public class CategoriaManagerImpl implements CategoriaManager{

	private CategoriaDAO categoriaDAO;
	
	@Autowired
	public CategoriaManagerImpl(CategoriaDAO categoriaDAO){
		this.categoriaDAO = categoriaDAO;
	}
	
	@Override
	public void insert(Categoria categoria) {
		categoriaDAO.insert(categoria);
	}

	@Override
	public void update(Categoria categoria) {
		categoriaDAO.update(categoria);
	}

	@Override
	public void delete(Categoria categoria) {
		categoriaDAO.delete(categoria);
	}

	@Override
	public List<Categoria> findAll() {
		return categoriaDAO.findAll();
	}

	@Override
	public Categoria findById(Long key) {
		return categoriaDAO.findById(key);
	}

}
