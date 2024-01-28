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
import mex.com.curso.Dto.ResponseDto;
import mex.com.curso.Dto.UsuariosAdminDTO;
import mex.com.curso.Entidades.UsuariosAdmin;
import mex.com.curso.Services.UsuariosAdminServices;

@Controller
@RequestMapping ("usuariosAdmin")
public class ControllerUsuariosAdmin {
	
	//Inyeccion de dependencias
	@Autowired
	private UsuariosAdminServices usuariosAdminServices;
	
	/*
	 * CRUD => insert - select - update - delete
	 * 
	 * Json => un conjunto de atributos - valor  -> {"NombreCompleto" : "Isaul Hdez Ramirez", "x": "x"}
	 * 
	 */
	
	//CONSULTA
	// Lista de usuarios por Hibernate --> lista de usuarios -> select * from tabla;
	@ResponseBody
    @RequestMapping(value="/getListaUsuarios", method = RequestMethod.GET, produces = "application/json")
	ResponseEntity <List<UsuariosAdmin>> obtenerUsuariosAdmin(){
		final HttpHeaders httpHeaders = new HttpHeaders();
		List<UsuariosAdmin> lista = usuariosAdminServices.obtenerUsuarios();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity <List<UsuariosAdmin>> (lista, httpHeaders, HttpStatus.OK);	
    } 
	
	
	
	
	// INSERTAR
	// Servicio para inserta un nuevo usuario por Hibernate -> insert into () values(?,?,?,?)
	@ResponseBody
	@RequestMapping(value="/insertUsuarios", method= RequestMethod.POST, produces = "application/json")
	ResponseEntity <ResponseDto> insertUsuarios(@RequestBody UsuariosAdminDTO nuevoUsuario){
		final HttpHeaders httpHeaders = new HttpHeaders();
		
		ResponseDto response = usuariosAdminServices.insertUsuariosAdmin(nuevoUsuario);
		
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		
		return new ResponseEntity <ResponseDto> (response, httpHeaders, HttpStatus.OK);
	}
	
	
	//CONSULTA CON CONDICIONAL
	// Lista de usuarios por Hibernate --> lista de usuarios los que tengan el estado 1 -> select * from tabla where estado = 1;
		@ResponseBody
	    @RequestMapping(value="/getListaUsuarios", method = RequestMethod.POST, produces = "application/json")
		ResponseEntity <List<UsuariosAdmin>> obtenerUsuariosAdminPorEstado(@RequestBody UsuariosAdminDTO datos){
			
			final HttpHeaders httpHeaders = new HttpHeaders();
			List<UsuariosAdmin> lista = usuariosAdminServices.obtenerUsuariosPorEstado(datos);
		
			httpHeaders.setContentType(MediaType.APPLICATION_JSON);
			return new ResponseEntity <List<UsuariosAdmin>> (lista, httpHeaders, HttpStatus.OK);	
	    } 
		
		
		//ELIMINAR REGISTRO
		// Lista de usuarios por Hibernate --> lista de usuarios los que tengan el estado 1 -> select * from tabla where estado = 1;
			@ResponseBody
		    @RequestMapping(value="/eliminarUsuarios", method = RequestMethod.DELETE, produces = "application/json")
			ResponseEntity <ResponseDto> eliminarUsuario(@RequestBody UsuariosAdminDTO datos){
				final HttpHeaders httpHeaders = new HttpHeaders();
		
				ResponseDto respuesta = usuariosAdminServices.eliminarUsuario(datos);
			
				httpHeaders.setContentType(MediaType.APPLICATION_JSON);
				return new ResponseEntity <ResponseDto> (respuesta, httpHeaders, HttpStatus.OK);	
		    } 
			
			
			
			//ACTUALIZA REGISTRO
			// Lista de usuarios por Hibernate --> lista de usuarios los que tengan el estado 1 -> select * from tabla where estado = 1;
				@ResponseBody
			    @RequestMapping(value="/actualizarUsuarios", method = RequestMethod.PUT, produces = "application/json")
				ResponseEntity <ResponseDto> actualizarUsuario(@RequestBody UsuariosAdminDTO datos){
					final HttpHeaders httpHeaders = new HttpHeaders();
			
					ResponseDto respuesta = usuariosAdminServices.actualizarUsuario(datos);
				
					httpHeaders.setContentType(MediaType.APPLICATION_JSON);
					return new ResponseEntity <ResponseDto> (respuesta, httpHeaders, HttpStatus.OK);	
			    }
				

				//CONSULTA POR IDENTIFICADOR --->SELECTR * FROM TABLA WHERE ID = ?
				
				@ResponseBody
			    @RequestMapping(value="/getUsuarioPorId", method = RequestMethod.PUT, produces = "application/json")
				public ResponseDto getUsuariosAdminPorId(@RequestBody UsuariosAdminDTO dato ){
					
					return usuariosAdminServices.getUsuariosAdminPorId(dato);
				}
						
			
			
				
				
} //Fin de la clase
	
	
