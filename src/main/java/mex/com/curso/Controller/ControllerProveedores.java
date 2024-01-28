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
import mex.com.curso.Dto.Proveedores;
import mex.com.curso.Dto.ResponseDto;
import mex.com.curso.Services.IProveedores;

@Controller //Anotacion
@RequestMapping("Prov") //Es buena practica poner nombre al controlador para diferenciar de los demas usando @RequestMapping
public class ControllerProveedores {

	@Autowired // Inyeccion de dependencias
	private IProveedores iProveedores;

	// Metodo GET, trae la consulta de la Base de datos en una aplicacion Json
	// (servicio de consulta a la BD)
	@ResponseBody // esta anotacion retorna informacion mas no nos lleva a una vista
	@RequestMapping(value = "/getProveedores", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Proveedores>> getProveedores() {
		final HttpHeaders httpHeaders = new HttpHeaders();
		List<Proveedores> proveedores = iProveedores.getProveedores();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON); // Tipo de contendio Json
		return new ResponseEntity<List<Proveedores>>(proveedores, httpHeaders, HttpStatus.OK);

	}

	// Metodo POST, hace el insert de datos en la Base de datos en una aplicacion Json
		// (servicio de insert a la BD)
	@ResponseBody // esta anotacion retorna informacion mas no nos lleva a una vista
	@RequestMapping(value = "/insertProveedores", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<ResponseDto> insertProveedores(@RequestBody Proveedores proveedores) {
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto response = new ResponseDto();
		response = iProveedores.insertProveedores(proveedores);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON); // Tipo de contendio Json
		return new ResponseEntity<ResponseDto>(response, httpHeaders, HttpStatus.OK);

	}
	

	// Metodo PUT, actualiza los datos en la Base de datos en una aplicacion Json
		// (servicio de actualizacion a la BD)
	@ResponseBody
	@RequestMapping (value="/actualizarProveedores", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<ResponseDto> actualizarProveedores(@RequestBody Proveedores proveedores){
	final HttpHeaders httpHeaders = new HttpHeaders();
	ResponseDto response = new ResponseDto();
	System.out.println("Entrando al controlador Client, metodo actualizarClientes");
	response = iProveedores.actualizarProveedores(proveedores); 
	System.out.println("Saliendo del metodo actualizarClientes de la implementacion del servicio");
	System.out.println("Regresando al controlador.");
	httpHeaders.setContentType(MediaType.APPLICATION_JSON);
	return new ResponseEntity <ResponseDto>(response,httpHeaders,HttpStatus.OK);
	
		 
	}
	
	// Metodo DELETE, ELIMINA el usuario mediante el id en la Base de datos en una aplicacion Json
	// (servicio de ELIMINAR a la BD
	@ResponseBody
	@RequestMapping (value="/eliminarProveedores", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<ResponseDto> eliminarProveedores(@RequestBody Proveedores proveedores){
	final HttpHeaders httpHeaders = new HttpHeaders();
	ResponseDto response = new ResponseDto();
	System.out.println("Entrando al controlador Prov, metodo eliminarProveedores");
	response = iProveedores.eliminarProveedores(proveedores); 
	System.out.println("Saliendo del metodo eliminarProveedores de la implementacion del servicio");
	System.out.println("Regresando al controlador.");
	httpHeaders.setContentType(MediaType.APPLICATION_JSON);
	return new ResponseEntity <ResponseDto>(response,httpHeaders,HttpStatus.OK);
	
		 
	}
	
	
	
	
	


}
