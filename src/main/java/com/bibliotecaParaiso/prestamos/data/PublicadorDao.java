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
import com.bibliotecaParaiso.prestamos.domain.Publicador;

@Repository
public class PublicadorDao {
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCallPublicadorInsertar;
	private SimpleJdbcCall simpleJdbcCallPublicadorActualizar;
	private SimpleJdbcCall simpleJdbcCallPublicadorBorrar;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCallPublicadorInsertar = new SimpleJdbcCall(dataSource).withProcedureName("InsertarPublicador");
		this.simpleJdbcCallPublicadorActualizar = new SimpleJdbcCall(dataSource).withProcedureName("actualizaPublicador");
		this.simpleJdbcCallPublicadorBorrar = new SimpleJdbcCall(dataSource).withProcedureName("eliminaPublicador");
	}
	
	@Transactional
	public int insert(String nombre, String lugar, String correo) {
		SqlParameterSource parameterSource = new MapSqlParameterSource()
				.addValue("nombre", nombre)
				.addValue("lugar", lugar)
				.addValue("correo", correo);
	
		Map<String, Object> outParameters = simpleJdbcCallPublicadorInsertar.execute(parameterSource);
	
		return Integer.parseInt(outParameters.get("codPublicador").toString());
	}
	
	
	
	
	public List<Publicador> select() {
		List<Publicador> publicadores = new ArrayList<>();

		String selectSql = "execute MuestraPublicadores";
		
		jdbcTemplate.query(selectSql, new Object[] {},
				(rs, row) -> new Publicador(rs.getInt("codPublicador"),
						rs.getString("nombre"),
						rs.getString("lugar"),
						rs.getString("correo")))
				.forEach(entry -> publicadores.add(entry));
		
		
		return publicadores;
	}
	
	
	@Transactional
	public boolean actualizar(int codigo, String nombre, String lugar, String correo) {
		try {
			SqlParameterSource parameterSource = new MapSqlParameterSource()
					.addValue("codPublicador", codigo)
					.addValue("nombre", nombre)
					.addValue("lugar", lugar)
					.addValue("correo", correo);
		
			Map<String, Object> outParameters = simpleJdbcCallPublicadorActualizar.execute(parameterSource);
			
			return true;
		} catch (Error e) {
			return false;
		}
		
	}
	
	@Transactional
	public boolean borrar(int codigo) {
		
		try {
			SqlParameterSource parameterSource = new MapSqlParameterSource()
					.addValue("codPublicador", codigo);
		
			Map<String, Object> outParameters = simpleJdbcCallPublicadorBorrar.execute(parameterSource);
			
			return true;
		} catch (Error e) {
			return false;
		}
		
	}
	
}
