package mex.com.curso.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mex.com.curso.Dto.Mascotas;


public class MascotasMapper <T> implements RowMapper<Mascotas> {

	@Override
	public Mascotas mapRow(ResultSet rs, int rowNum) throws SQLException {
		Mascotas mascotas = new Mascotas();
		mascotas.setIdMascota(rs.getInt("ID_MASCOTA"));
		mascotas.setNombreMascota(rs.getString("NOMBRE_MASCOTA"));
		mascotas.setRaza(rs.getString("RAZA"));
		mascotas.setAlergias(rs.getString("ALERGIAS"));
		mascotas.setEdad(rs.getInt("EDAD"));
		mascotas.setDieta(rs.getString("DIETA"));
		return mascotas;
	}
	

}
