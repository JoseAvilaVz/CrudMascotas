package mex.com.curso.Repository;

import java.util.List;


import mex.com.curso.Dto.Cliente;


public interface IClientesRepository {
	
	public List<Cliente> getClientes();
	public Integer insertClientes(Cliente clientes);
	public Integer actualizarClientes(Cliente clientes);
	public Integer eliminarClientes(Cliente clientes);
	
	
}
