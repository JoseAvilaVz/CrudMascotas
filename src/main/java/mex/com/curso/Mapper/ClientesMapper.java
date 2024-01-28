package mex.com.curso.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import mex.com.curso.Dto.Cliente;


public class ClientesMapper<T> implements RowMapper<Cliente> {

	@Override
	public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
		Cliente clientes  = new Cliente ();
		clientes.setIdCliente(rs.getLong("ID_CLIENTE"));
		clientes.setNombre(rs.getString("NOMBRE"));
		clientes.setApellidoPaterno(rs.getString("APELLIDO_PATERNO"));
		clientes.setApellidoMaterno(rs.getString("APELLIDO_MATERNO"));
		clientes.setEdad(rs.getLong("EDAD"));
		clientes.setEmail(rs.getString("EMAIL"));
		clientes.setDireccion(rs.getString("DIRECCION"));
		clientes.setTelefono(rs.getLong("TELEFONO"));
		clientes.setSexo(rs.getString("SEXO"));

			return clientes;

	}

	
	
	}


	


