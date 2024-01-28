package mex.com.curso.RepositoryImplement;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import mex.com.curso.Dto.Mascotas;

import mex.com.curso.Mapper.MascotasMapper;
import mex.com.curso.Repository.IMascotasRepository;

@Repository
public class MascotasRepositoryImplement implements IMascotasRepository {

	@Autowired
	private DataSource dataSource; // Conexion a la base de datos
	private JdbcTemplate jdbcTemplate = new JdbcTemplate(); // se encarga de las consultas a la BD

	@Override
	public List<Mascotas> getMascotas() {
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.query("SELECT * FROM MASCOTAS", new MascotasMapper<Mascotas>());
	}

	@Override
	public Integer insertMascotas(Mascotas mascotas) {
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.update(
				"INSERT INTO MASCOTAS " + "(ID_MASCOTA, NOMBRE_MASCOTA, RAZA, ALERGIAS, EDAD, DIETA)"
						+ "VALUES(?,?,?,?,?,?)",
				new Object[] { mascotas.getIdMascota(), mascotas.getNombreMascota(), mascotas.getRaza(),
						mascotas.getAlergias(), mascotas.getEdad(), mascotas.getDieta() });
	}

	@Override
	public Integer actualizarMascotas(Mascotas mascotas) {
		System.out.println("LLegando a la implementacion del repositorio del metodo actualizarMascotas");
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.update(
				"UPDATE MASCOTAS SET NOMBRE_MASCOTA = ?, RAZA = ?, ALERGIAS = ?, EDAD = ?, "
						+ "DIETA = ? WHERE ID_MASCOTA = ?",
				new Object[] { mascotas.getNombreMascota(), mascotas.getRaza(), mascotas.getAlergias(),
						mascotas.getEdad(), mascotas.getDieta(), mascotas.getIdMascota() });

	}

	@Override
	public Integer eliminarMascotas(Mascotas mascotas) {
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.update("DELETE FROM MASCOTAS WHERE ID_MASCOTA = ?", mascotas.getIdMascota());
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
