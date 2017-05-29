package com.bibliotecaParaiso.prestamos.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bibliotecaParaiso.prestamos.domain.Categoria;
import com.bibliotecaParaiso.prestamos.domain.Historial;

@Repository
public class CategoriaDao {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public int insert(String nombre) {
		List<Categoria> categorias = new ArrayList<>();
		
		String selectSql = "execute sp_categoria_insert "+nombre;
		jdbcTemplate
				.query(selectSql, new Object[] {},
						(rs, row) -> new Categoria(rs.getInt("codigo")))
				.forEach(entry ->  categorias.add(entry));
		
		return categorias.get(0).getCodigo();
	}
	
	
	/*@Transactional
	public int insert(String nombre) {
		SqlParameterSource parameterSource = new MapSqlParameterSource()
				.addValue("codUsuario", prestamo.getUsuario().getCodigoUsuario())
				.addValue("codLibro", prestamo.getLibro().getCodigo());
	
		Map<String, Object> outParameters = simpleJdbcCallPrestamo.execute(parameterSource);
	
		prestamo.setCodigo(Integer.parseInt(outParameters.get("codPrestamo").toString()));
	
		return prestamo;
	}*/
	
}
