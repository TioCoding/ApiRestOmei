package com.rest.omei.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import com.rest.omei.daointerface.PlatoDAO;
import com.rest.omei.entity.Categoria;
import com.rest.omei.entity.Plato;

@Repository
public class PlatoDAOImpl implements PlatoDAO {

	private JdbcOperations jdbcOperations;
	private final String INSERT_PLATO = "INSERT INTO Platos (PLATO_ID,PLATO_NOM,CAT_ID,PLATO_PRECIO) values(?,?,?,?)";
	private final String UPDATE_PLATO = "UPDATE Platos SET PLATO_NOM = ?,CAT_ID = ?,PLATO_PRECIO = ? WHERE PLATO_ID = ?";
	private final String DELETE_PLATO = "DELETE FROM Platos WHERE PLATO_ID = ?";
	private final String FIND_ALL = "SELECT PLATO_ID,PLATO_NOM,CAT_ID,PLATO_PRECIO FROM Platos";
	private final String FIND_BY_ID = "SELECT PLATO_ID,PLATO_NOM,CAT_ID,PLATO_PRECIO FROM Platos WHERE PLATO_ID = ?";
	private final String FIND_ALL_WITH_CAT = "SELECT p.PLATO_ID,p.PLATO_NOM,c.CAT_ID,c.CAT_NOM,p.PLATO_PRECIO FROM Platos p INNER JOIN Categorias c on p.CAT_ID = c.CAT_ID";

	@Autowired
	public PlatoDAOImpl(JdbcOperations jdbcOperations) {
		this.jdbcOperations = jdbcOperations;
	}

	@Override
	public void insert(Plato plato) {
		jdbcOperations.update(INSERT_PLATO, plato.getCodigo(), plato.getNombre(), plato.getCategoria(),
				plato.getPrecio());
	}

	@Override
	public void update(Plato plato) {
		jdbcOperations.update(UPDATE_PLATO, plato.getNombre(), plato.getCategoria(), plato.getPrecio(),
				plato.getCodigo());
	}

	@Override
	public void delete(Plato plato) {
		jdbcOperations.update(DELETE_PLATO, plato.getCodigo());
	}

	@Override
	public List<Plato> findAll() {
		return jdbcOperations.query(FIND_ALL, (rs, row) -> new Plato(rs.getString("PLATO_ID"),
				rs.getString("PLATO_NOM"), rs.getDouble("PLATO_PRECIO")));
	}

	@Override
	public Plato findById(Long key) {
		try {
			return jdbcOperations.queryForObject(FIND_BY_ID, (rs, row) -> new Plato(rs.getString("PLATO_ID"),
					rs.getString("PLATO_NOM"), rs.getDouble("PLATO_PRECIO")), key);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}

	}

	@Override
	public List<Plato> findAllWhitCategoria() {
		try {
			return jdbcOperations.query(FIND_ALL_WITH_CAT,
					(rs, row) -> new Plato(rs.getString("PLATO_ID"), rs.getString("PLATO_NOM"),
							rs.getDouble("PLATO_PRECIO"),
							new Categoria(rs.getLong("CAT_ID"), rs.getString("CAT_NOM"))));
		} catch (EmptyResultDataAccessException e) {
			return null;
		}

	}

}
