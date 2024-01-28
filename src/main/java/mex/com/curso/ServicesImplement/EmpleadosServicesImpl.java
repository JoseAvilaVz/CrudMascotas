package mex.com.curso.ServicesImplement;

import java.util.List;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mex.com.curso.Dto.EmpleadosDTO;
import mex.com.curso.Dto.ResponseDto;
import mex.com.curso.Entidades.Empleados;

import mex.com.curso.Repository.EmpleadosDAO;
import mex.com.curso.Services.EmpleadosServices;

// CAPA DE NEGOCIO!!!!!!!!!!!!!!!
@Service
public class EmpleadosServicesImpl implements EmpleadosServices {

	@Autowired
	private EmpleadosDAO empleadosDAO;

	// Consulta con hibernate consulta en una lista todos los empleados
	@Override
	public List<Empleados> ObtenerEmpleados() {
		List<Empleados> listaEmpleados = empleadosDAO.getEmpleados();
		return listaEmpleados;
	}

	// ESTE METODO ES PARA INSERTAR CON HHIBERNET
	// Un service para insertar nuevos empleados
	// REGLA I.- Antes de insertar un empleado verificar si ya EXISTE ese usuario en
	// la base de datos

	/*
	 * public ResponseDto insertEmpleado(EmpleadosDTO nuevoEmpleado) { ResponseDto
	 * response = new ResponseDto(); // INICIALIZAMOS EL OBJETO EN VACIO Empleados
	 * existeEmp = empleadosDAO.obtenerEmpleadosPorRfc(nuevoEmpleado); if (existeEmp
	 * != null) { response.setCode(100);
	 * response.setMessage("El empleado ya existe");
	 * 
	 * } else {
	 * 
	 * 
	 * Empleados objeto = new Empleados(); // creando un obj con
	 * nombre->(objtEntidad) de la clase entiudad
	 * objeto.setIdEmpleado(nuevoEmpleado.getIdEmpleado());
	 * objeto.setNombreCompleto(nuevoEmpleado.getNombreCompleto());
	 * objeto.setRfc(nuevoEmpleado.getRfc());
	 * objeto.setCurp(nuevoEmpleado.getCurp());
	 * objeto.setEdad(nuevoEmpleado.getEdad());
	 * objeto.setSexo(nuevoEmpleado.getSexo());
	 * objeto.setDireccion(nuevoEmpleado.getDireccion());
	 * objeto.setNss(nuevoEmpleado.getNss());
	 * objeto.setTelefono(nuevoEmpleado.getTelefono());
	 * objeto.setActivo(nuevoEmpleado.getActivo());
	 * 
	 * empleadosDAO.create(objeto);// create --> insert con hibernate
	 * response.setCode(200);
	 * response.setMessage("Los datos se insertaron correctamente..!");
	 * 
	 * } return response;
	 * 
	 * }
	 */

	@Override
	public ResponseDto insertEmpleado(EmpleadosDTO nuevoEmpleado) {
		ResponseDto response = new ResponseDto(); // INICIALIZAMOS EL OBJETO EN VACIO
		Empleados existeEmp = empleadosDAO.obtenerEmpleadosPorRfc(nuevoEmpleado);

		if (existeEmp != null) {
			response.setCode(100);
			response.setMessage("El empleado ya existe");

		} else {

			Empleados objeto = new Empleados(); // creando un obj con nombre->(objtEntidad) de la clase entiudad
			objeto.setIdEmpleado(nuevoEmpleado.getIdEmpleado());
			objeto.setNombreCompleto(nuevoEmpleado.getNombreCompleto());
			objeto.setRfc(nuevoEmpleado.getRfc());
			objeto.setCurp(nuevoEmpleado.getCurp());
			objeto.setEdad(nuevoEmpleado.getEdad());
			objeto.setSexo(nuevoEmpleado.getSexo());
			objeto.setDireccion(nuevoEmpleado.getDireccion());
			objeto.setNss(nuevoEmpleado.getNss());
			objeto.setTelefono(nuevoEmpleado.getTelefono());
			objeto.setActivo(nuevoEmpleado.getActivo());

			empleadosDAO.create(objeto);// create --> insert con hibernate
			response.setCode(200);
			response.setMessage("Los datos se insertaron correctamente..!");

		}
		return response;

	}

	// ESTE METODO (DELETE) ES PARA ELIMINAR CON HHIBERNET
	// Un service para ELIMINAR empleados mediante ID
	/*
	 * REGLA I.- Se puede eliminar siempre y cuando este dado de baja, si no esta
	 * dado de baja ese empleado mostrar un mensaje de ->
	 * "Imposible eliminar Empleado, Sigue Laborando (Activo)...! ", En caso
	 * contrario el siguiente mensaje -> "Empleado eliminado correctamente"
	 */
	@Override
	public ResponseDto eliminarEmpleados(EmpleadosDTO dato) {
		ResponseDto response = new ResponseDto();
		empleadosDAO.read(dato.getIdEmpleado());
		if (dato.getActivo() == 1) {
			response.setCode(200);
			response.setMessage("Imposible eliminar Empleado, Sigue Laborando (Activo)...!");
		} else {
			empleadosDAO.delete(dato.getIdEmpleado());
			response.setCode(200);
			response.setMessage("Empleado eliminado correctamente");
		}

		return response;
	}

	// ESTE METODO (UPDATE) ES PARA ACTUALIZAR CON HHIBERNET
	// Un service para ACTUALIZAR empleados

	@Override
	public ResponseDto actualizarEmpleado(EmpleadosDTO dato) {
		ResponseDto response = new ResponseDto();
		Empleados objeto = new Empleados(); // creando un obj con nombre->(objtEntidad) de la clase entiudad
		objeto.setIdEmpleado(dato.getIdEmpleado());
		objeto.setNombreCompleto(dato.getNombreCompleto());
		objeto.setRfc(dato.getRfc());
		objeto.setCurp(dato.getCurp());
		objeto.setEdad(dato.getEdad());
		objeto.setSexo(dato.getSexo());
		objeto.setDireccion(dato.getDireccion());
		objeto.setNss(dato.getNss());
		objeto.setTelefono(dato.getTelefono());
		objeto.setActivo(dato.getActivo());

		empleadosDAO.update(objeto);
		response.setCode(200);
		response.setMessage("El Empleado se actualizo correctamente");

		return response;

	}// CRUD - END

	/*
	 * CONSULTAS PERSONALIZADAS CON REGLAS DE NEGOCIO
	 */

	// Consulta con condicional para obnter empleados mediante el RFC
	@Override
	public ResponseDto obtenerEmpleadosPorRfc(EmpleadosDTO dato) {
		ResponseDto response = new ResponseDto();
		Empleados existeEmp = empleadosDAO.obtenerEmpleadosPorRfc(dato);
		if (existeEmp != null) {
			response.setCode(200);
			response.setMessage("Encontrado");
		} else {
			// empleadosDAO.equals(dato.getRfc())
			response.setCode(100);
			response.setMessage("No encontrado");
		}
		return response;
	}

	// Consulta con condicional por Id
	@Override
	public ResponseDto getEmpleadosPorId(EmpleadosDTO dato) {
		ResponseDto response = new ResponseDto();
		if (dato.getIdEmpleado() != null || dato.getIdEmpleado() != 0) {
			empleadosDAO.read(dato.getIdEmpleado());
			response.setCode(200);
			response.setMessage("Usuario localizado");

		} else {

			response.setCode(100);
			response.setMessage("Usuario no localizado");

		}

		return response;
	}

	// Consulta con condicional en hibernate --> consulta en una lista todos los
	// empleados Activos
	@Override
	public List<Empleados> obtenerEmpleadosPorEstado(EmpleadosDTO dato) {
		List<Empleados> listaEmpleadosPorEstado = empleadosDAO.getEmpleadosPorEstado(dato);
		return listaEmpleadosPorEstado;
	}

	// Consulta con condicional en hibernate --> consulta en una lista todos los
	// empleados de genero Masculino
	// LISTO
	@Override
	public List<Empleados> obtenerEmpleadosMasc(EmpleadosDTO dato) {
		List<Empleados> listaEmpleadosMasc = empleadosDAO.getEmpleadosMasc(dato);
		return listaEmpleadosMasc;
	}

	// Consulta con condicional doble en hibernate --> consulta en una lista todos
	// los empleados de genero Femenino
	// de edad = ?
	// LISTO
	@Override
	public List<Empleados> obtenerEmpleadosFem(EmpleadosDTO dato) {
		List<Empleados> listaEmpleadosFem = empleadosDAO.getEmpleadosFem(dato);
		return listaEmpleadosFem;
	}
	
	

	@Override
	public ResponseDto validarRfc(EmpleadosDTO dato) {
		ResponseDto response = new ResponseDto();
	
		String rfc = dato.getRfc();

		String patronRfc = "^[A-Z]{4}[0-9]{6}[A-Z0-9]{3}$";
		

		Pattern patternRfc = Pattern.compile(patronRfc);
	

		Matcher matcherRfc = patternRfc.matcher(rfc);
		

		if (matcherRfc.matches()) {

			response.setCode(200);
			response.setMessage("RFC valido");
		} else {

			response.setCode(100);
			response.setMessage("RFC no valido");

		}

		return response;
	}

	/*@Override
	public ResponseDto insertarEmpValidarRfc(EmpleadosDTO dato) {
		ResponseDto response = new ResponseDto();
		

		String rfc = dato.getRfc();

		String patronRfc = "^[A-Z]{4}[0-9]{6}[A-Z0-9]{3}$";

		Pattern patternRfc = Pattern.compile(patronRfc);

		Matcher matcherRfc = patternRfc.matcher(rfc);

		if (matcherRfc.matches()) {
			
			Empleados objeto = new Empleados(); // creando un obj con nombre->(objtEntidad) de la clase entiudad
			objeto.setIdEmpleado(dato.getIdEmpleado());
			objeto.setNombreCompleto(dato.getNombreCompleto());
			objeto.setRfc(dato.getRfc());
			objeto.setCurp(dato.getCurp());
			objeto.setEdad(dato.getEdad());
			objeto.setSexo(dato.getSexo());
			objeto.setDireccion(dato.getDireccion());
			objeto.setNss(dato.getNss());
			objeto.setTelefono(dato.getTelefono());
			objeto.setActivo(dato.getActivo());

			empleadosDAO.create(objeto);// create --> insert con hibernate
			response.setCode(200);
			response.setMessage("Los datos se insertaron correctamente..!");

			
		} else {

			response.setCode(100);
			response.setMessage("RFC no valido");

		}

		return response;
	}
	
	*/

	@Override
	public ResponseDto validarCurp(EmpleadosDTO dato) {
		ResponseDto response = new ResponseDto();
		

		String curp = dato.getCurp();
		String rfc = dato.getRfc();

		String patronCurp = "^[A-Z]{4}[0-9]{6}[HM][A-Z]{5}[0-9]{2}$";
		String patronRfc = "^[A-Z]{4}[0-9]{6}[A-Z0-9]{3}$";

		Pattern patternCurp = Pattern.compile(patronCurp);
		Pattern patternRfc = Pattern.compile(patronRfc);

		Matcher matcherCurp = patternCurp.matcher(curp);
		Matcher matcherRfc = patternRfc.matcher(rfc);
		

		if (matcherCurp.matches() && matcherRfc.matches()) {
			Empleados objeto = new Empleados(); // creando un obj con nombre->(objtEntidad) de la clase entiudad
			objeto.setIdEmpleado(dato.getIdEmpleado());
			objeto.setNombreCompleto(dato.getNombreCompleto());
			objeto.setRfc(dato.getRfc());
			objeto.setCurp(dato.getCurp());
			objeto.setEdad(dato.getEdad());
			objeto.setSexo(dato.getSexo());
			objeto.setDireccion(dato.getDireccion());
			objeto.setNss(dato.getNss());
			objeto.setTelefono(dato.getTelefono());
			objeto.setActivo(dato.getActivo());

			empleadosDAO.create(objeto);// create --> insert con hibernate
			response.setCode(200);
			response.setMessage("Los datos se insertaron correctamente..!");
			response.setMessage("CURP valido");
		} else {

			response.setCode(100);
			response.setMessage("La curp no cuenta con la estrutura adecuada");

		}
		return response;
	}

	@Override
	public ResponseDto validarNss(EmpleadosDTO dato) {
	
		ResponseDto response = new ResponseDto();
	
		int nss = dato.getNss();

		String PATRON_NSS = "^[0-9]{11}$";
		

		Pattern patternNss = Pattern.compile(PATRON_NSS);
	

		Matcher matcherNss = patternNss.matcher(String.valueOf(nss));
		
		
		if (matcherNss.matches()) {

			response.setCode(200);
			response.setMessage("Nss valido");
		} else {

			response.setCode(100);
			response.setMessage("El campo nss debe ser númerico");

		}
		
		return response;
	}

	@Override
	public ResponseDto insertarEmpValidarRfc(EmpleadosDTO dato) {
		// TODO Auto-generated method stub
		return null;
	}

}// fin
