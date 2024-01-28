package mex.com.curso.ServicesImplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mex.com.curso.Dto.Cliente;
import mex.com.curso.Dto.ResponseDto;
import mex.com.curso.Repository.IClientesRepository;
import mex.com.curso.Services.IClientes;

@Service
public class ClientesServicesImplement implements IClientes {

	@Autowired 
	private IClientesRepository iClientesRepository;
	
	@Override
	public List<Cliente> getClientes() {
		return iClientesRepository.getClientes();
	}

	public ResponseDto insertClientes(Cliente clientes) {
		ResponseDto response = new ResponseDto();
		Integer respuesta = 0;
		respuesta = iClientesRepository.insertClientes(clientes);
		if(respuesta ==1){
			response.setCode(1);
			response.setMessage("Se inserto correctamente");
		}
		else {
			response.setCode(0);
			response.setMessage("No se inserto");
		}
		return response;
	}

	@Override
	public ResponseDto actualizarClientes(Cliente clientes) {
		System.out.println("LLegando a la implementacion del servicio en el metodo actualizarClientes");
		ResponseDto response = new ResponseDto();
		Integer respuesta = iClientesRepository.actualizarClientes(clientes);
		System.out.println("Saliendo del metodo actualizarClientes de la implementacion del repositorio");
		if(respuesta==1) {
			response.setCode(1);
			response.setMessage("Se Actualizo Correctamente el cliente: "+clientes.getNombre()+"Con Id: "+clientes.getIdCliente());
		}
		else {
			response.setCode(0);
			response.setMessage("No Se Actualizo Correctamente el cliente: "+clientes.getNombre()+"Con Id: "+clientes.getIdCliente());
		}
		return response;
	}

	@Override
	public ResponseDto eliminarClientes(Cliente clientes) {
		ResponseDto response = new ResponseDto();
		Integer respuesta = iClientesRepository.eliminarClientes(clientes);
		System.out.println("Saliendo del metodo eliminarClientes de la implementacion del repositorio");
		if(respuesta==1) {
			response.setCode(1);
			response.setMessage("Se Elimino Correctamente el nombre del vendedor: "+clientes.getNombre()+"con id: "+ clientes.getIdCliente());
		}
		else {
			response.setCode(0);
			response.setMessage("No Se Elimino Correctamente el nombre del vendedor: "+clientes.getNombre());
		}
		return response;
	}
	
	

}
