package mex.com.curso.ServicesImplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mex.com.curso.Dto.Pagos;
import mex.com.curso.Dto.ResponseDto;
import mex.com.curso.Repository.IPagosRepository;
import mex.com.curso.Services.IPagos;

@Service 
public class PagosServiceImplement implements IPagos {

	@Autowired
	private IPagosRepository iPagosRepository;
	
	//Metod GET
	@Override
	public List<Pagos> getPagos() {
		return iPagosRepository.getPagos();
	}
//Metod POST
	@Override
	public ResponseDto insertPagos(Pagos pago) {
		ResponseDto response = new ResponseDto();
		Integer respuesta=0;
		respuesta=iPagosRepository.insertPagos(pago);
		if (respuesta==1) {
			response.setCode(1);
			response.setMessage("se inserto correctamente");
					}
		else {
			
			response.setCode(0);
			response.setMessage("No se inserto");
		}
		return response;
	}

	//Metod PUT
	@Override
	public ResponseDto actualizarPagos(Pagos pago) {
		System.out.println("LLegando a la implementacion del servicio en el metodo actualizarClientes");
		ResponseDto response = new ResponseDto();
		Integer respuesta = iPagosRepository.actualizarPagos(pago);
		System.out.println("Saliendo del metodo actualizarClientes de la implementacion del repositorio");
		if(respuesta==1) {
			response.setCode(1);
			response.setMessage("Se Actualizo Correctamente el pago del cliente: "+pago.getNombreCliente());
		}
		else {
			response.setCode(0);
			response.setMessage("No Se Actualizo Correctamente el pago del cliente: "+pago.getNombreCliente());
		}
		return response;
	}
	
	//Metod DEL
	@Override
	public ResponseDto eliminarPagos(Pagos pago) {
		ResponseDto response = new ResponseDto();
		Integer respuesta = iPagosRepository.eliminarPagos(pago);
		System.out.println("Saliendo del metodo eliminarPagos de la implementacion del repositorio");
		if(respuesta==1) {
			response.setCode(1);
			response.setMessage("Se Elimino Correctamente el nombre del Cliente: "+pago.getNombreCliente()+"con id: "+ pago.getIdPago());
		}
		else {
			response.setCode(0);
			response.setMessage("No Se Elimino Correctamente el nombre del Cliente: "+pago.getNombreCliente());
		}
		return response;
	}

}
