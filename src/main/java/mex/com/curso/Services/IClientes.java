package mex.com.curso.Services;

import java.util.List;

import mex.com.curso.Dto.Cliente;
import mex.com.curso.Dto.ResponseDto;

public interface IClientes {

	public List<Cliente> getClientes();
	public ResponseDto insertClientes(Cliente clientes);
	public ResponseDto actualizarClientes(Cliente clientes);
	public ResponseDto eliminarClientes(Cliente clientes);
	
}
