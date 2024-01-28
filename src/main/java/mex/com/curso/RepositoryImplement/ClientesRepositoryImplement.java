package mex.com.curso.RepositoryImplement;

import java.util.List;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import mex.com.curso.Dto.Cliente;
import mex.com.curso.Mapper.ClientesMapper;
import mex.com.curso.Repository.IClientesRepository;

@Repository
public class ClientesRepositoryImplement implements IClientesRepository {

	@Autowired
	private DataSource dataSource;//Conexion  a base de datos
	private JdbcTemplate jdbcTemplate = new JdbcTemplate();
	
	
	@Override 
	public List<Cliente> getClientes() {
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.query("SELECT * FROM CLIENTES", new ClientesMapper<Cliente>());
	}
	
	
	
	@Override
	public Integer insertClientes(Cliente clientes) {
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.update("INSERT INTO CLIENTES " +
	"(NOMBRE, APELLIDO_PATERNO, APELLIDO_MATERNO, EDAD, EMAIL, DIRECCION, TELEFONO, SEXO)"+
	"VALUES(?,?,?,?,?,?,?,?)",new Object [] {clientes.getNombre(), clientes.getApellidoPaterno(),
			clientes.getApellidoMaterno(), clientes.getEdad(), clientes.getEmail(), clientes.getDireccion(),
			clientes.getTelefono(), clientes.getSexo()});
	}
	
	@Override
	public Integer actualizarClientes(Cliente clientes) {
		System.out.println("LLegando a la implementacion del repositorio del metodo actualizarClientes");
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.update("UPDATE CLIENTES SET NOMBRE = ?, APELLIDO_PATERNO = ?, APELLIDO_MATERNO = ?, EDAD = ?, "
				+ "EMAIL = ?, DIRECCION = ?, TELEFONO = ?, SEXO = ? WHERE ID_CLIENTE = ?", new Object [] {clientes.getNombre(),
						clientes.getApellidoPaterno(), clientes.getApellidoMaterno(), clientes.getEdad(),
						clientes.getEmail(), clientes.getDireccion(), clientes.getTelefono(), clientes.getSexo(),
						clientes.getIdCliente()});
	}
	
	@Override
	public Integer eliminarClientes(Cliente clientes) {
		System.out.println("LLegando a la implementacion del repositorio del metodo eliminarClientes");
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.update("DELETE FROM CLIENTES WHERE ID_CLIENTE = ?", clientes.getIdCliente());
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

	
