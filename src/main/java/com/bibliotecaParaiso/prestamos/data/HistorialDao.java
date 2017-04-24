package com.bibliotecaParaiso.prestamos.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bibliotecaParaiso.prestamos.domain.Historial;

@Repository
public class HistorialDao {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<Historial> showAllHistory(int id) {
		List<Historial> historial = new ArrayList<>();
		
		String selectSql = "execute MostrarHistorialPrestamos "+id+", "+5;
		jdbcTemplate
				.query(selectSql, new Object[] {},
						(rs, row) -> new Historial(rs.getInt("codigo"), rs.getInt("codigo_persona"),
								rs.getInt("codigo_libro"), rs.getString("tipo"), rs.getDate("fecha_transaccion") + "",
								rs.getString("titulo_libro"), rs.getDate("fecha_prestamo") + "",
								rs.getDate("fecha_limite") + "", rs.getDate("fecha_devolucion") + ""))
				.forEach(entry -> historial.add(entry));
		return historial;
	}
	
	public List<Integer> numRegistros(){
		double numRegistros = 0;
		int num = 1;
		String selectSql = "execute numRegistros";
		List<Integer> listaNum = new ArrayList<>();
		numRegistros = jdbcTemplate.queryForObject(selectSql, Integer.class);
		
		num = (int) Math.ceil(numRegistros/5);
		
		System.out.println("numregistros= "+numRegistros+", num= "+num);
		
		
		for(int i=1; i<=num; i++){
			listaNum.add(i);
		}
		
		return listaNum;
	}
}
