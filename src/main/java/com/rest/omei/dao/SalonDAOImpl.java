package com.rest.omei.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import com.rest.omei.daointerface.SalonDAO;
import com.rest.omei.entity.Mesa;
import com.rest.omei.entity.Salon;

@Repository
public class SalonDAOImpl implements SalonDAO {

	private JdbcOperations jdbcOperations;
	private final String INSERT_SALON = "INSERT INTO Salones (SALON_NOM,SALON_DESCRIPCION) VALUES(?,?);";
	private final String UPDATE_SALON = "UPDATE Salones SET SALON_NOM = ?,SALON_DESCRIPCION = ? WHERE SALON_ID = ?";
	private final String DELETE_SALON = "DELETE FROM Salones WHERE SALON_ID = ?";
	private final String FIND_ALL = "SELECT SALON_ID,SALON_NOM,SALON_DESCRIPCION FROM Salones";
	private final String FIND_BY_ID = "SELECT SALON_ID,SALON_NOM,SALON_DESCRIPCION FROM Salones WHERE SALON_ID = ?";
	private final String FIND_MESAS_BY_SALON = "SELECT MESA_ID,MESA_DESCRIPCION FROM MESAS WHERE SALON_ID = ?";

	@Autowired
	public SalonDAOImpl(JdbcOperations jdbcOperations) {
		this.jdbcOperations = jdbcOperations;
	}

	@Override
	public void insert(Salon salon) {
		jdbcOperations.update(INSERT_SALON, salon.getNombre(), salon.getDescripcion());
	}

	@Override
	public void update(Salon salon) {
		jdbcOperations.update(UPDATE_SALON, salon.getNombre(), salon.getDescripcion(), salon.getCodigo());
	}

	@Override
	public void delete(Salon salon) {
		jdbcOperations.update(DELETE_SALON, salon.getCodigo());
	}

	@Override
	public List<Salon> findAll() {
		try {
			return jdbcOperations.query(FIND_ALL,
					(rs, row) -> new Salon(rs.getLong("SALON_ID"), rs.getString("SALON_NOM"),
							rs.getString("SALON_DESCRIPCION"), jdbcOperations.query(FIND_MESAS_BY_SALON,
									(rs2, row2) -> new Mesa(rs2.getLong("MESA_ID"), rs2.getString("MESA_DESCRIPCION")),
									rs.getLong("SALON_ID"))));
		} catch (EmptyResultDataAccessException e) {
			return null;
		}

	}

	@Override
	public Salon findById(Long key) {
		try {
			return jdbcOperations.queryForObject(FIND_BY_ID, (rs, row) -> new Salon(rs.getLong("SALON_ID"),
					rs.getString("SALON_NOM"), rs.getString("SALON_DESCRIPCION")), key);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}

	}

}
