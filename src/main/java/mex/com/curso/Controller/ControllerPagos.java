package mex.com.curso.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import mex.com.curso.Dto.Pagos;
import mex.com.curso.Dto.ResponseDto;
import mex.com.curso.Services.IPagos;

@Controller  				//Anotacion para definir que este es un controlador
@RequestMapping ("Pag") 	// Esta anotacion permite definir un nombre para que se diferencie
public class ControllerPagos {
	
	@Autowired 
	private IPagos iPagos;
	
	//Metodo GET, trae la consulta de la Base de datos generando una aplicacion Json
	@ResponseBody
	@RequestMapping (value="/getPagos", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Pagos>>getPagos(){
		final HttpHeaders httpHeaders = new HttpHeaders();
		List<Pagos> pagos = iPagos.getPagos();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity <List<Pagos>>(pagos,httpHeaders,HttpStatus.OK);
	}

	//Metodo POST, inserta nuevos datos a la Base de datos generando una aplicacion Json
	@ResponseBody
	@RequestMapping (value="/insertPagos", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<ResponseDto>insertPagos(@RequestBody Pagos pago){
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto response = new ResponseDto();
		response = iPagos.insertPagos(pago);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity <ResponseDto>(response,httpHeaders,HttpStatus.OK);
	}
	
	
	//Metodo PUT, ACTUALIZA e INSERTA datos a la Base de datos generando una aplicacion Json
		@ResponseBody
		@RequestMapping (value="/actualizarPagos", method = RequestMethod.PUT, produces = "application/json")
		public ResponseEntity<ResponseDto>actualizarPagos(@RequestBody Pagos pago){
			final HttpHeaders httpHeaders = new HttpHeaders();
			ResponseDto response = new ResponseDto();
			response = iPagos.actualizarPagos(pago);
			httpHeaders.setContentType(MediaType.APPLICATION_JSON);
			return new ResponseEntity <ResponseDto>(response,httpHeaders,HttpStatus.OK);
		}
		
		//Metodo DELETE, ELIMINAR datos a la Base de datos
				@ResponseBody
				@RequestMapping (value="/eliminarPagos", method = RequestMethod.DELETE, produces = "application/json")
				public ResponseEntity<ResponseDto>eliminarPagos(@RequestBody Pagos pago){
					final HttpHeaders httpHeaders = new HttpHeaders();
					ResponseDto response = new ResponseDto();
					response = iPagos.eliminarPagos(pago);
					httpHeaders.setContentType(MediaType.APPLICATION_JSON);
					return new ResponseEntity <ResponseDto>(response,httpHeaders,HttpStatus.OK);
				}
	
}
