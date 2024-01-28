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

import mex.com.curso.Dto.Cliente;
import mex.com.curso.Dto.ResponseDto;
import mex.com.curso.Services.IClientes;

@Controller // anotacion que indica que es un controlador
@RequestMapping ("Client")
public class ControllerClientes {
	
	@Autowired
	private IClientes iClientes;
	
	//Metodo GET, trae la consulta de la Base de datos en una aplicacion Json
	@ResponseBody
	@RequestMapping (value="/getClientes", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Cliente>> getClientes(){
	final HttpHeaders httpHeaders = new HttpHeaders();
	List<Cliente> clientes = iClientes.getClientes();
	httpHeaders.setContentType(MediaType.APPLICATION_JSON);
	return new ResponseEntity <List<Cliente>>(clientes,httpHeaders,HttpStatus.OK);
	
		 
	}
	
	//Metodo POST, hace la insersion de datos en la tabla
	
	@ResponseBody
	@RequestMapping (value="/insertClientes", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<ResponseDto> insertClientes(@RequestBody Cliente cliente){
	final HttpHeaders httpHeaders = new HttpHeaders();
	ResponseDto response = new ResponseDto();
	response = iClientes.insertClientes(cliente);
	httpHeaders.setContentType(MediaType.APPLICATION_JSON);
	return new ResponseEntity <ResponseDto>(response,httpHeaders,HttpStatus.OK);
	
		 
	}
	
	//Metodo ACTUALIZAR,
	
	@ResponseBody
	@RequestMapping (value="/actualizarClientes", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<ResponseDto> actualizarClientes(@RequestBody Cliente cliente){
	final HttpHeaders httpHeaders = new HttpHeaders();
	ResponseDto response = new ResponseDto();
	System.out.println("Entrando al controlador Client, metodo actualizarClientes");
	response = iClientes.actualizarClientes(cliente); 
	System.out.println("Saliendo del metodo actualizarClientes de la implementacion del servicio");
	System.out.println("Regresando al controlador.");
	httpHeaders.setContentType(MediaType.APPLICATION_JSON);
	return new ResponseEntity <ResponseDto>(response,httpHeaders,HttpStatus.OK);
	
		 
	}
	
	//Metodo DELETE,
	
	@ResponseBody
	@RequestMapping (value="/eliminarClientes", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<ResponseDto> eliminarClientes(@RequestBody Cliente cliente){
	final HttpHeaders httpHeaders = new HttpHeaders();
	ResponseDto response = new ResponseDto();
	System.out.println("Entrando al controlador Client, metodo eliminarClientes");
	response = iClientes.eliminarClientes(cliente); 
	System.out.println("Saliendo del metodo eliminarClientes de la implementacion del servicio");
	System.out.println("Regresando al controlador.");
	httpHeaders.setContentType(MediaType.APPLICATION_JSON);
	return new ResponseEntity <ResponseDto>(response,httpHeaders,HttpStatus.OK);
	
		 
	}
	
	
	  
	

	

}
