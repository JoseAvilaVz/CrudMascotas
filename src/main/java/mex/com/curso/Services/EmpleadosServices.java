package mex.com.curso.Services;

import java.util.List;

import mex.com.curso.Dto.EmpleadosDTO;
import mex.com.curso.Dto.ResponseDto;
import mex.com.curso.Entidades.Empleados;

public interface EmpleadosServices {

	List<Empleados> ObtenerEmpleados();
	
	ResponseDto insertEmpleado(EmpleadosDTO nuevoEmpleado);
	
	List<Empleados> obtenerEmpleadosPorEstado(EmpleadosDTO dato);

	ResponseDto eliminarEmpleados(EmpleadosDTO dato);

	ResponseDto actualizarEmpleado(EmpleadosDTO dato);

	ResponseDto getEmpleadosPorId(EmpleadosDTO dato);

	List<Empleados> obtenerEmpleadosMasc(EmpleadosDTO dato);

	List<Empleados> obtenerEmpleadosFem(EmpleadosDTO dato);

	ResponseDto obtenerEmpleadosPorRfc(EmpleadosDTO dato);

	ResponseDto validarRfc(EmpleadosDTO dato);

	ResponseDto insertarEmpValidarRfc(EmpleadosDTO dato);

	ResponseDto validarCurp(EmpleadosDTO dato);

	ResponseDto validarNss(EmpleadosDTO dato);



	



	


	


	

	

	
	

}
