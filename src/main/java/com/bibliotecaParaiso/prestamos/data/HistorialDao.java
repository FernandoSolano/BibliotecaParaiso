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

	public List<Historial> showAllHistory() {
		List<Historial> historial = new ArrayList<>();
		//String selectSql = "select codigo, tipo, fecha_transaccion," + " codigo_persona, codigo_libro, titulo_libro,"
		//		+ " fecha_prestamo, fecha_limite, fecha_devolucion" + " from Historial_Prestamos";
		String selectSql = "execute MostrarHistorialPrestamos";
		jdbcTemplate
				.query(selectSql, new Object[] {},
						(rs, row) -> new Historial(rs.getInt("codigo"), rs.getInt("codigo_persona"),
								rs.getInt("codigo_libro"), rs.getString("tipo"), rs.getDate("fecha_transaccion") + "",
								rs.getString("titulo_libro"), rs.getDate("fecha_prestamo") + "",
								rs.getDate("fecha_limite") + "", rs.getDate("fecha_devolucion") + ""))
				.forEach(entry -> historial.add(entry));
		return historial;
	}
}
