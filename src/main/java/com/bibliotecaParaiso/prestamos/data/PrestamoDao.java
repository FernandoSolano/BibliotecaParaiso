package com.bibliotecaParaiso.prestamos.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bibliotecaParaiso.prestamos.domain.Historial;
import com.bibliotecaParaiso.prestamos.domain.Libro;
import com.bibliotecaParaiso.prestamos.domain.Usuario;

@Repository
public class PrestamoDao {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public boolean solicitarPrestamo() {
		return false;
	}
	
	public List<Usuario> listaUsuarios(){
		List<Usuario> usuarios = new ArrayList<>();
		
		String selectSql = "execute muestraUsuarios";
		jdbcTemplate
				.query(selectSql, new Object[] {},
						(rs, row) -> new Usuario(
								rs.getString("cedula")))
				.forEach(entry -> usuarios.add(entry));
		
		return usuarios;
	}
	
	public List<Libro> listaLibros(){
		List<Libro> libros = new ArrayList<>();
		
		String selectSql = "execute muestraLibros";
		jdbcTemplate
				.query(selectSql, new Object[] {},
						(rs, row) -> new Libro(rs.getString("titulo")))
				.forEach(entry -> libros.add(entry));
		
		return libros;
	}
	
}
