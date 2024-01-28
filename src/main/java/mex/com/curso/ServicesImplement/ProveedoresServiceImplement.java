package mex.com.curso.ServicesImplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mex.com.curso.Dto.Proveedores;
import mex.com.curso.Dto.ResponseDto;
import mex.com.curso.Repository.IProveedoresRepository;
import mex.com.curso.Services.IProveedores;

@Service // se usa @Service para hacerlo capa de servicio
public class ProveedoresServiceImplement implements IProveedores { // heredamos la interface creada (implements
																	// IProveedores)

	@Autowired
	private IProveedoresRepository iProveedoresRepository;

	@Override
	public List<Proveedores> getProveedores() {

		return iProveedoresRepository.getProveedores();
	}

	@Override
	public ResponseDto insertProveedores(Proveedores proveedores) {
		ResponseDto response = new ResponseDto();
		Integer respuesta = 0;
		respuesta = iProveedoresRepository.insertProveedores(proveedores);
		if (respuesta == 1) {
			response.setCode(1);
			response.setMessage("Se inserto correctamente");
		} else {
			response.setCode(0);
			response.setMessage("No se inserto");
		}
		return response;
	}

	@Override
	public ResponseDto actualizarProveedores(Proveedores proveedores) {
		System.out.println("LLegando a la implementacion del servicio en el metodo actualizarClientes");
		ResponseDto response = new ResponseDto();
		Integer respuesta = iProveedoresRepository.actualizarProveedores(proveedores);
		System.out.println("Saliendo del metodo actualizarClientes de la implementacion del repositorio");
		if (respuesta == 1) {
			response.setCode(1);
			response.setMessage("Se Actualizo Correctamente el cliente: " + proveedores.getNombreProveedor()
					+ "Con Id: " + proveedores.getIdProveedor());
		} else {
			response.setCode(0);
			response.setMessage("No Se Actualizo Correctamente el cliente: " + proveedores.getNombreProveedor()
					+ "Con Id: " + proveedores.getIdProveedor());
		}
		return response;
	}

	@Override
	public ResponseDto eliminarProveedores(Proveedores proveedores) {
		ResponseDto response = new ResponseDto();
		Integer respuesta = iProveedoresRepository.eliminarProveedores(proveedores);
		System.out.println("Saliendo del metodo eliminarProveedores de la implementacion del repositorio");
		if (respuesta == 1) {
			response.setCode(1);
			response.setMessage("Se Elimino Correctamente el Proveedor: " + proveedores.getNombreProveedor()
					+ "con id: " + proveedores.getIdProveedor());
		} else {
			response.setCode(0);
			response.setMessage("No Se Elimino Correctamente el Proveedor con ID: " + proveedores.getIdProveedor());
		}
		return response;
	}

}
