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
import mex.com.curso.Dto.EmpleadosDTO;
import mex.com.curso.Dto.ResponseDto;
import mex.com.curso.Entidades.Empleados;
import mex.com.curso.Services.EmpleadosServices;

@Controller
@RequestMapping("Empleados")
public class ControllerEmpleados {

	// Inyeccion de dependencias
	@Autowired
	private EmpleadosServices EmpleadosServices; // HACEMOS LA UNION DEL CONTROLLER CON SERVICES

	/*
	 * ----CONSULTA Empleados---- Lista de Empleados por Hibernate --> lista de
	 * Empleados -> select * from tabla ESTE SERVICIO CONSULTA A TODOS LOS EMPLEADOS
	 * ES DE TIPO LISTA -----LISTO-----
	 */

	@ResponseBody
	@RequestMapping(value = "/getListaEmpleados", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Empleados>> ObtenerEmpleados() { // ResponseEntity<List<Empleados>> ObtenerEmpleados()

		final HttpHeaders httpHeaders = new HttpHeaders();
		List<Empleados> lista = EmpleadosServices.ObtenerEmpleados();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<List<Empleados>>(lista, httpHeaders, HttpStatus.OK);
	}

	/*
	 * ----INSERTAR Empleados----(Un service para insertar nuevos empleados)
	 * Servicio para inserta un nuevo EMPLEADO por Hibernate -> insert into ()
	 * values(?,?,?,?) ES DE TIPO RESPUESTA
	 */

	@ResponseBody
	@RequestMapping(value = "/insertEmpleado", method = RequestMethod.POST, produces = "application/json")
	ResponseEntity<ResponseDto> insertEmpleado(@RequestBody EmpleadosDTO nuevoEmpleado) {
		final HttpHeaders httpHeaders = new HttpHeaders();

		ResponseDto response = EmpleadosServices.insertEmpleado(nuevoEmpleado);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<ResponseDto>(response, httpHeaders, HttpStatus.OK);
	}

	/*
	 * ----ELIMINAR Empleados----ELIMINAR REGISTRO DE LA TABLA EMPLEADOS Lista de
	 * usuarios por Hibernate --> lista de usuarios los que tengan el estado 1 ->
	 * --> select * from tabla where estado = 1; ES DE TIPO RESPUESTA
	 */

	@ResponseBody
	@RequestMapping(value = "/eliminarEmpleados", method = RequestMethod.DELETE, produces = "application/json")
	ResponseEntity<ResponseDto> eliminarEmpleados(@RequestBody EmpleadosDTO dato) {

		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto respuesta = EmpleadosServices.eliminarEmpleados(dato);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<ResponseDto>(respuesta, httpHeaders, HttpStatus.OK);
	}

	/*
	 * ----ACTUALIZAR Empleados----ACTUALIZA REGISTRO Lista de usuarios por
	 * Hibernate --> lista de usuarios, los que tengan el estado 1 -> select * from
	 * tabla where estado = 1; ES DE TIPO RESPUESTA
	 */

	@ResponseBody
	@RequestMapping(value = "/actualizarEmpleados", method = RequestMethod.PUT, produces = "application/json")
	ResponseEntity<ResponseDto> actualizarEmpleado(@RequestBody EmpleadosDTO dato) {

		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto response = EmpleadosServices.actualizarEmpleado(dato);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<ResponseDto>(response, httpHeaders, HttpStatus.OK);
	}

	// CRUD-End

	/*
	 * Comienzan las consultas personalizadas
	 */

	// Consulta por estado ACTIVO O INACTIVO (1 o 0)
	// Lista de usuarios por Hibernate
	@ResponseBody
	@RequestMapping(value = "/getEmpleadosPorEstado", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<List<Empleados>> obtenerEmpleadosPorEstado(@RequestBody EmpleadosDTO dato) { // ResponseEntity<List<Empleados>>
		// ObtenerEmpleados()
		final HttpHeaders httpHeaders = new HttpHeaders();
		List<Empleados> lista = EmpleadosServices.obtenerEmpleadosPorEstado(dato);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<List<Empleados>>(lista, httpHeaders, HttpStatus.OK);
	}

//Consulta por identificador --> select * from tabla where Id = ?
	@ResponseBody
	@RequestMapping(value = "/getEmpleadosPorId", method = RequestMethod.POST, produces = "application/json")
	public ResponseDto getEmpleadosPorId(@RequestBody EmpleadosDTO dato) {

		return EmpleadosServices.getEmpleadosPorId(dato);
	}

	// Servicio para consultar todos los usuarios de sexo Masculino -- LISTO

	@ResponseBody
	@RequestMapping(value = "/getListaEmpleadosMasc", method = RequestMethod.POST, produces = "application/json")
	ResponseEntity<List<Empleados>> ObtenerEmpleadosMasc(@RequestBody EmpleadosDTO dato) { // ResponseEntity<List<Empleados>>
																							// ObtenerEmpleados()

		final HttpHeaders httpHeaders = new HttpHeaders();
		List<Empleados> lista = EmpleadosServices.obtenerEmpleadosMasc(dato);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<List<Empleados>>(lista, httpHeaders, HttpStatus.OK);
	}

	// Servicio para consultar todos los usuarios de sexo Femenino de 35 años LISTO

	@ResponseBody
	@RequestMapping(value = "/getListaEmpleadosFem", method = RequestMethod.POST, produces = "application/json")
	ResponseEntity<List<Empleados>> ObtenerEmpleadosFem(@RequestBody EmpleadosDTO dato) { // ResponseEntity<List<Empleados>>
																							// ObtenerEmpleados()

		final HttpHeaders httpHeaders = new HttpHeaders();
		List<Empleados> lista = EmpleadosServices.obtenerEmpleadosFem(dato);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<List<Empleados>>(lista, httpHeaders, HttpStatus.OK);
	}

	// Consulta por RFC --> select * from EMPLEADOS where RFC = ? LISTO
	@ResponseBody
	@RequestMapping(value = "/getEmpleadosPorRfc", method = RequestMethod.POST, produces = "application/json")
	ResponseEntity<ResponseDto> obtenerEmpleadosPorRfc(@RequestBody EmpleadosDTO dato) {
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto response = EmpleadosServices.obtenerEmpleadosPorRfc(dato);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<ResponseDto>(response, httpHeaders, HttpStatus.OK);

	}

	/*
	 * ----CONSULTA PARA VLIDAR RFC----(Un service para validar el rfc de los
	 * empleados) Servicio para validar que este correctamente estructurado el rfc
	 * de un empleado
	 */
	@ResponseBody
	@RequestMapping(value = "/validarRfc", method = RequestMethod.POST, produces = "application/json")
	ResponseEntity<ResponseDto> validarRfc(@RequestBody EmpleadosDTO dato) {
		final HttpHeaders httpHeaders = new HttpHeaders();

		ResponseDto response = EmpleadosServices.validarRfc(dato);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<ResponseDto>(response, httpHeaders, HttpStatus.OK);
	}

	/*
	 * ----CONSULTA PARA VLIDAR RFC----(Un service para validar el rfc de los
	 * empleados) Servicio para validar que este correctamente estructurado el rfc
	 * de un empleado
	 */
	@ResponseBody
	@RequestMapping(value = "/InsertarEmpValidarRfc", method = RequestMethod.POST, produces = "application/json")
	ResponseEntity<ResponseDto> insertarEmpValidarRfc(@RequestBody EmpleadosDTO dato) {
		final HttpHeaders httpHeaders = new HttpHeaders();

		ResponseDto response = EmpleadosServices.insertarEmpValidarRfc(dato);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<ResponseDto>(response, httpHeaders, HttpStatus.OK);
	}

	/*
	 * ----CONSULTA PARA VLIDAR RFC----(Un service para validar el rfc de los
	 * empleados) Servicio para validar que este correctamente estructurado el rfc
	 * de un empleado
	 */
	@ResponseBody
	@RequestMapping(value = "/validarCurp", method = RequestMethod.POST, produces = "application/json")
	ResponseEntity<ResponseDto> validarCurp(@RequestBody EmpleadosDTO dato) {
		final HttpHeaders httpHeaders = new HttpHeaders();

		ResponseDto response = EmpleadosServices.validarCurp(dato);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<ResponseDto>(response, httpHeaders, HttpStatus.OK);
	}
	
	
	/*
	 * ----CONSULTA PARA VLIDAR NSS----(Un service para validar el rfc de los
	 * empleados) Servicio para validar que este correctamente estructurado el rfc
	 * de un empleado
	 */
	@ResponseBody
	@RequestMapping(value = "/validarNss", method = RequestMethod.POST, produces = "application/json")
	ResponseEntity<ResponseDto> validarNss(@RequestBody EmpleadosDTO dato) {
		final HttpHeaders httpHeaders = new HttpHeaders();

		ResponseDto response = EmpleadosServices.validarNss(dato);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<ResponseDto>(response, httpHeaders, HttpStatus.OK);
	}
	
	

} // Fin de la estructura
