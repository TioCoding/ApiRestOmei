package com.rest.omei.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import com.rest.omei.daointerface.PedidoDAO;
import com.rest.omei.entity.Mesa;
import com.rest.omei.entity.Pedido;

@Repository
public class PedidoDAOImpl implements PedidoDAO {

	private JdbcOperations jdbcOperations;
	private final String INSERT_PEDIDO = "INSERT INTO Pedidos (MESA_ID) values(?)";
	private final String UPDATE_PEDIDO = "UPDATE Pedidos SET MESA_ID = ? WHERE PEDI_ID = ?";
	private final String DELETE_PEDIDO = "DELETE FROM Pedidos WHERE PLATO_ID = ?";
	private final String FIND_ALL = "SELECT PEDI_ID,MESA_ID FROM Pedidos";
	private final String FIND_BY_ID = "SELECT PEDI_ID,MESA_ID FROM Pedidos WHERE PEDI_ID = ?";

	@Autowired
	public PedidoDAOImpl(JdbcOperations jdbcOperations) {
		this.jdbcOperations = jdbcOperations;
	}

	@Override
	public void insert(Pedido pedido) {
		jdbcOperations.update(INSERT_PEDIDO, pedido.getMesa().getCodigo());
	}

	@Override
	public void update(Pedido pedido) {
		jdbcOperations.update(UPDATE_PEDIDO, pedido.getMesa().getCodigo(), pedido.getCodigo());
	}

	@Override
	public void delete(Pedido pedido) {
		jdbcOperations.update(DELETE_PEDIDO, pedido.getCodigo());
	}

	@Override
	public List<Pedido> findAll() {
		try {
			return jdbcOperations.query(FIND_ALL,
					(rs, row) -> new Pedido(rs.getLong("PEDI_ID"), new Mesa(rs.getLong("MESA_ID"))));
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public Pedido findById(Long key) {
		try {
			return jdbcOperations.queryForObject(FIND_BY_ID,
					(rs, row) -> new Pedido(rs.getLong("PEDI_ID"), new Mesa(rs.getLong("MESA_ID"))), key);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

}
