package com.bibliotecaParaiso.prestamos.data;

import java.sql.SQLException;
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

import com.bibliotecaParaiso.prestamos.domain.Historial;
import com.bibliotecaParaiso.prestamos.domain.Libro;
import com.bibliotecaParaiso.prestamos.domain.Prestamo;
import com.bibliotecaParaiso.prestamos.domain.Usuario;

@Repository
public class PrestamoDao {
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCallPrestamo;
	private SimpleJdbcCall simpleJdbcCallDevolucion;
	private SimpleJdbcCall simpleJdbcCallRenovarPrestamo;
	private SimpleJdbcCall simpleJdbcCallLibrosRecomendados;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCallPrestamo = new SimpleJdbcCall(dataSource).withProcedureName("InsertarPrestamo");
		this.simpleJdbcCallDevolucion = new SimpleJdbcCall(dataSource).withProcedureName("eliminarPrestamo");
		this.simpleJdbcCallRenovarPrestamo = new SimpleJdbcCall(dataSource).withProcedureName("Renovacion");
		this.simpleJdbcCallLibrosRecomendados = new SimpleJdbcCall(dataSource).withProcedureName("LibrosRecomendados");		
	}

	public List<Usuario> listaUsuarios() {
		List<Usuario> usuarios = new ArrayList<>();

		String selectSql = "execute muestraUsuarios";
		jdbcTemplate
				.query(selectSql, new Object[] {},
						(rs, row) -> new Usuario(rs.getInt("codigo"), rs.getString("cedula")))
				.forEach(entry -> usuarios.add(entry));

		return usuarios;
	}

	public List<Libro> listaLibros() {
		List<Libro> libros = new ArrayList<>();

		String selectSql = "execute muestraLibrosDisponibles";
		jdbcTemplate
				.query(selectSql, new Object[] {}, (rs, row) -> new Libro(rs.getInt("codigo"), rs.getString("titulo")))
				.forEach(entry -> libros.add(entry));
		
		return libros;
	}
	
	public List<Prestamo> listaPrestamos() {
		List<Prestamo> prestamos = new ArrayList<>();

		String selectSql = "execute muestraPrestamos";
		
		jdbcTemplate.query(selectSql, new Object[] {},
				(rs, row) -> new Prestamo(rs.getInt("codigo"),
						rs.getString("fecha_prestamo"),
						rs.getString("nombre"),
						rs.getString("titulo")))
				.forEach(entry -> prestamos.add(entry));
		
		
		return prestamos;
	}

	@Transactional
	public Prestamo insertarPrestamo(Prestamo prestamo) throws SQLException {

		SqlParameterSource parameterSource = new MapSqlParameterSource()
				.addValue("codUsuario", prestamo.getUsuario().getCodigoUsuario())
				.addValue("codLibro", prestamo.getLibro().getCodigo());

		Map<String, Object> outParameters = simpleJdbcCallPrestamo.execute(parameterSource);

		prestamo.setCodigo(Integer.parseInt(outParameters.get("codPrestamo").toString()));

		return prestamo;
	}

	@Transactional
	public boolean devolucion(int codigo) {

		try {
			SqlParameterSource parametroDevolucion = new MapSqlParameterSource().addValue("id", codigo);

			Map<String, Object> outParameters = simpleJdbcCallDevolucion.execute(parametroDevolucion);
			return true;
		} catch (Error e) {
			return false;
		}

	}
	
	@Transactional
	public boolean renovacion(int codigoPrestamo) {
		try{
			SqlParameterSource procedimientoRenovacion = new MapSqlParameterSource().addValue("codPrestamo", codigoPrestamo);
			simpleJdbcCallRenovarPrestamo.execute(procedimientoRenovacion);
			return true;
		} catch (Error e) {
			return false;
		}
	}
	
	public List<Libro> getRecomendaciones(int codigoUsuario){
		SqlParameterSource procedimientoLibrosRecomendados = new MapSqlParameterSource().addValue("cod_usuario", codigoUsuario);
		simpleJdbcCallLibrosRecomendados.execute(procedimientoLibrosRecomendados);
		
		List<Libro> libros = new ArrayList<>();
		String selectSql = "execute muestraLibrosRecomendados";
		jdbcTemplate
		.query(selectSql, new Object[] {},
				(rs, row) -> new Libro(rs.getInt("codigo"), rs.getString("titulo")))
		.forEach(entry -> libros.add(entry));
		return libros;
		
	/*	List<Libro> libros = new ArrayList<>();

		String selectSql = "execute LibrosRecomendados "+codigoUsuario;
		jdbcTemplate
				.query(selectSql, new Object[] {},
						(rs, row) -> new Libro(rs.getInt("codigo"), rs.getString("titulo")))
				.forEach(entry -> libros.add(entry));

		return libros;
	*/
	}
}
