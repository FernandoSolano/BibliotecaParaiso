package com.bibliotecaParaiso.prestamos.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bibliotecaParaiso.prestamos.domain.Categoria;
import com.bibliotecaParaiso.prestamos.domain.Historial;
import com.bibliotecaParaiso.prestamos.domain.Prestamo;

@Repository
public class CategoriaDao {
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCallCategoriaInsertar;
	private SimpleJdbcCall simpleJdbcCallCategoriaActualizar;
	private SimpleJdbcCall simpleJdbcCallCategoriaBorrar;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCallCategoriaInsertar = new SimpleJdbcCall(dataSource).withProcedureName("sp_categoria_insert");
		this.simpleJdbcCallCategoriaActualizar = new SimpleJdbcCall(dataSource).withProcedureName("sp_categoria_update");
		this.simpleJdbcCallCategoriaBorrar = new SimpleJdbcCall(dataSource).withProcedureName("sp_categoria_delete");
	}
	
	@Transactional
	public int insert(String nombre) {
		SqlParameterSource parameterSource = new MapSqlParameterSource()
				.addValue("nombre", nombre);
	
		Map<String, Object> outParameters = simpleJdbcCallCategoriaInsertar.execute(parameterSource);
	
		return Integer.parseInt(outParameters.get("codigo").toString());
	}
	
	public List<Categoria> select() {
		List<Categoria> categorias = new ArrayList<>();

		String selectSql = "execute sp_categoria_get";
		
		jdbcTemplate.query(selectSql, new Object[] {},
				(rs, row) -> new Categoria(rs.getInt("codigo"),
						rs.getString("nombre")))
				.forEach(entry -> categorias.add(entry));
		
		
		return categorias;
	}
	
	@Transactional
	public boolean actualizar(int codigo, String nombre) {
		try {
			SqlParameterSource parameterSource = new MapSqlParameterSource()
					.addValue("codigo", codigo)
					.addValue("nombre", nombre);
		
			Map<String, Object> outParameters = simpleJdbcCallCategoriaActualizar.execute(parameterSource);
			
			return true;
		} catch (Error e) {
			return false;
		}
		
	}
	
	@Transactional
	public boolean borrar(int codigo) {
		
		System.out.println("codigo : "+codigo);
		
		try {
			SqlParameterSource parameterSource = new MapSqlParameterSource()
					.addValue("codigo", codigo);
		
			Map<String, Object> outParameters = simpleJdbcCallCategoriaBorrar.execute(parameterSource);
			
			return true;
		} catch (Error e) {
			return false;
		}
		
	}
	
}
