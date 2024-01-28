package mex.com.curso.Services;

import java.util.List;
import mex.com.curso.Dto.Cliente;
import mex.com.curso.Dto.ResponseDto;

public interface ITransferencias {
	
	public String getTransferencias();
	
	public List<Cliente> getClientes();
	public ResponseDto insertClientes(Cliente clientes);

}
