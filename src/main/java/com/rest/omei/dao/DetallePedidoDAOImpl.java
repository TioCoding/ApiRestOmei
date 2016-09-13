package com.rest.omei.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import com.rest.omei.daointerface.DetallePedidoDAO;
import com.rest.omei.entity.DetallePedido;
import com.rest.omei.entity.DetallePedido.CodigoDetallePedido;
import com.rest.omei.entity.Pedido;
import com.rest.omei.entity.Plato;

@Repository
public class DetallePedidoDAOImpl implements DetallePedidoDAO {

	private JdbcOperations jdbcOperations;
	private final String INSERT_DETALLE_PEDIDO = "INSERT INTO Detalle_Pedido (PEDI_ID,PLATO_ID,DETA_SUB_NOMBRE,DETA_PRECIO,DETA_CANTIDAD) values(?,?,?,?,?)";
	private final String UPDATE_DETALLE_PEDIDO = "UPDATE Detalle_Pedido SET DETA_SUB_NOMBRE=?,DETA_PRECIO=?,DETA_CANTIDAD=? WHERE PEDI_ID = ? AND PLATO_ID = ?";
	private final String DELETE_DETALLE_PEDIDO = "DELETE FROM Detalle_Pedido WHERE PEDI_ID = ? AND PLATO_ID = ?";
	private final String FIND_ALL = "SELECT PEDI_ID,PLATO_ID,DETA_SUB_NOMBRE,DETA_PRECIO,DETA_CANTIDAD FROM Detalle_Pedido";
	private final String FIND_BY_ID = "SELECT PEDI_ID,PLATO_ID,DETA_SUB_NOMBRE,DETA_PRECIO,DETA_CANTIDAD FROM Detalle_Pedido WHERE PEDI_ID = ? AND PLATO_ID = ?";

	@Autowired
	public DetallePedidoDAOImpl(JdbcOperations jdbcOperations) {
		this.jdbcOperations = jdbcOperations;
	}

	@Override
	public void insert(DetallePedido detallePedido) {
		jdbcOperations.update(INSERT_DETALLE_PEDIDO, detallePedido.getCodigo().getPedido().getCodigo(),
				detallePedido.getCodigo().getPlato().getCodigo(), detallePedido.getSubNombre(),
				detallePedido.getPrecio(), detallePedido.getCantidad());
	}

	@Override
	public void update(DetallePedido detallePedido) {
		jdbcOperations.update(UPDATE_DETALLE_PEDIDO, detallePedido.getSubNombre(), detallePedido.getPrecio(),
				detallePedido.getCantidad(), detallePedido.getCodigo().getPedido().getCodigo(),
				detallePedido.getCodigo().getPlato().getCodigo());
	}

	@Override
	public void delete(DetallePedido detallePedido) {
		jdbcOperations.update(DELETE_DETALLE_PEDIDO, detallePedido.getCodigo().getPedido().getCodigo(),
				detallePedido.getCodigo().getPlato().getCodigo());
	}

	@Override
	public List<DetallePedido> findAll() {
		try {
			return jdbcOperations.query(FIND_ALL,
					(rs, row) -> new DetallePedido(
							new DetallePedido().new CodigoDetallePedido(new Pedido(rs.getLong("PEDI_ID")),
									new Plato(rs.getString("PLATO_ID"))),
							rs.getString("DETA_SUB_NOMBRE"), rs.getDouble("DETA_PRECIO"),
							rs.getDouble("DETA_CANTIDAD")));
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public DetallePedido findById(CodigoDetallePedido key) {
		try {
			return jdbcOperations.queryForObject(FIND_BY_ID,
					(rs, row) -> new DetallePedido(
							new DetallePedido().new CodigoDetallePedido(new Pedido(rs.getLong("PEDI_ID")),
									new Plato(rs.getString("PLATO_ID"))),
							rs.getString("DETA_SUB_NOMBRE"), rs.getDouble("DETA_PRECIO"),
							rs.getDouble("DETA_CANTIDAD")),
					key.getPedido().getCodigo(), key.getPlato().getCodigo());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

}
