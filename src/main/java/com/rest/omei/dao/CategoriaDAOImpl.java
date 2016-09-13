package com.rest.omei.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import com.rest.omei.daointerface.CategoriaDAO;
import com.rest.omei.entity.Categoria;

@Repository
public class CategoriaDAOImpl implements CategoriaDAO {

	private JdbcOperations jdbcOperations;
	private final String INSERT_CATEGORIA = "INSERT INTO Categorias (CAT_NOM) VALUES (?)";
	private final String UPDATE_CATEGORIA = "UPDATE Categorias SET CAT_NOM = ? WHERE CAT_ID = ?";
	private final String DELETE_CATEGORIA = "DELETE FROM Categorias WHERE CAT_ID = ?";
	private final String FIND_ALL = "SELECT CAT_ID, CAT_NOM FROM Categorias";
	private final String FIND_BY_ID = "SELECT CAT_ID, CAT_NOM FROM Categorias WHERE CAT_ID = ?";

	@Autowired
	public CategoriaDAOImpl(JdbcOperations jdbcOperations) {
		this.jdbcOperations = jdbcOperations;
	}

	@Override
	public void insert(Categoria categoria) {
		jdbcOperations.update(INSERT_CATEGORIA, categoria.getCategoria());
	}

	@Override
	public void update(Categoria categoria) {
		jdbcOperations.update(UPDATE_CATEGORIA, categoria.getCategoria(), categoria.getCodigo());
	}

	@Override
	public void delete(Categoria categoria) {
		jdbcOperations.update(DELETE_CATEGORIA, categoria.getCodigo());
	}

	@Override
	public List<Categoria> findAll() {
		try {
			return jdbcOperations.query(FIND_ALL,
					(rs, row) -> new Categoria(rs.getLong("CAT_ID"), rs.getString("CAT_NOM")));
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public Categoria findById(Long key) {
		try {
			return jdbcOperations.queryForObject(FIND_BY_ID,
					(rs, row) -> new Categoria(rs.getLong("CAT_ID"), rs.getString("CAT_NOM")), key);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

}
