package com.rest.omei.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import com.rest.omei.daointerface.MesaDAO;
import com.rest.omei.entity.Mesa;

@Repository
public class MesaDAOImpl implements MesaDAO {

	private JdbcOperations jdbcOperations;
	private final String INSERT_MESA = "INSERT INTO Mesas (SALON_ID,MESA_DESCRIPCION) VALUES(?,?);";
	private final String UPDATE_MESA = "UPDATE Mesas SET SALON_ID = ?,MESA_DESCRIPCION = ? WHERE MESA_ID = ?";
	private final String DELETE_MESA = "DELETE FROM Mesas WHERE MESA_ID = ?";
	private final String FIND_ALL = "SELECT MESA_ID,SALON_ID,MESA_DESCRIPCION FROM Mesas";
	private final String FIND_BY_ID = "SELECT MESA_ID,SALON_ID,MESA_DESCRIPCION FROM Mesas WHERE MESA_ID = ?";

	@Autowired
	public MesaDAOImpl(JdbcOperations jdbcOperations) {
		this.jdbcOperations = jdbcOperations;
	}

	@Override
	public void insert(Mesa mesa) {
		jdbcOperations.update(INSERT_MESA, mesa.getSalon(), mesa.getDescripcion());
	}

	@Override
	public void update(Mesa mesa) {
		jdbcOperations.update(UPDATE_MESA, mesa.getSalon(), mesa.getDescripcion(), mesa.getCodigo());
	}

	@Override
	public void delete(Mesa mesa) {
		jdbcOperations.update(DELETE_MESA, mesa.getCodigo());
	}

	@Override
	public List<Mesa> findAll() {
		try {
			return jdbcOperations.query(FIND_ALL,
					(rs, row) -> new Mesa(rs.getLong("MESA_ID"), rs.getString("MESA_DESCRIPCION")));
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public Mesa findById(Long key) {
		try {
			return jdbcOperations.queryForObject(FIND_BY_ID,
					(rs, row) -> new Mesa(rs.getLong("MESA_ID"), rs.getString("MESA_DESCRIPCION")));
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

}
