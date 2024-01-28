package mex.com.curso.RepositoryImplement;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import mex.com.curso.Dto.Proveedores;
import mex.com.curso.Mapper.ProveedoresMapper;
import mex.com.curso.Repository.IProveedoresRepository;

@Repository // Anotacion 
public class ProveedoresRepositoryImplement implements IProveedoresRepository{ // hereda la interface del repositorio ( implements IProveedoresRepository)
	
	@Autowired
	private DataSource dataSource; // este objeto es la conexion a la BD, se peude ver en la clase DATABASECONFIG
	 private JdbcTemplate jdbcTemplate = new JdbcTemplate(); // se encarga de las consultas a BD
	 
	
	@Override 
	public List<Proveedores> getProveedores() { //
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.query("SELECT * FROM PROVEEDORES", new ProveedoresMapper<Proveedores>());
	}
	
	
	@Override
	public Integer insertProveedores(Proveedores proveedores) {
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.update("INSERT INTO PROVEEDORES " +
	"(ID_PROVEEDOR, NOMBREPROV, NUM_EMPLEADO, FECHA_INGRESO, SALARIO, PUESTO)"+
	"VALUES(?,?,?,?,?,?)",new Object [] { proveedores.getIdProveedor(), proveedores.getNombreProveedor(),
			proveedores.getNumEmpleado(), proveedores.getFechaIngreso(), proveedores.getSalario(),
			proveedores.getPuesto()});

	}
	
	
	@Override
	public Integer actualizarProveedores(Proveedores proveedores) {
		System.out.println("LLegando a la implementacion del repositorio del metodo actualizarProveedores");
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.update("UPDATE PROVEEDORES SET NOMBREPROV = ?, NUM_EMPLEADO = ?,FECHA_INGRESO = ?, SALARIO = ?, "
				+ "PUESTO = ? WHERE ID_PROVEEDOR = ?", new Object [] {
						proveedores.getNombreProveedor(), proveedores.getNumEmpleado(), proveedores.getFechaIngreso(),
						proveedores.getSalario(), proveedores.getPuesto(), proveedores.getIdProveedor()});
	}
	
	@Override
	public Integer eliminarProveedores(Proveedores proveedores) {
		//System.out.println("LLegando a la implementacion del repositorio del metodo EliminarProveedores");
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.update("DELETE FROM PROVEEDORES WHERE ID_PROVEEDOR = ?", proveedores.getIdProveedor());
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
