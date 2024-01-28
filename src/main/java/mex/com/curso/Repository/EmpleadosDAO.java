package mex.com.curso.Repository;

import java.util.List;

import mex.com.curso.Dto.EmpleadosDTO;
import mex.com.curso.Dto.ResponseDto;
import mex.com.curso.Entidades.Empleados;

// DAO  ES UN PATRON DE DISEÑO (DATA ACCESS OBJECT) TIENE REGLAS QUWE CUMPLIR
public interface EmpleadosDAO extends DAO<Empleados, Long> {

	List<Empleados> getEmpleados();

	List<Empleados> getEmpleadosPorEstado(EmpleadosDTO dato);

	List<Empleados> getEmpleadosMasc(EmpleadosDTO dato);

	List<Empleados> getEmpleadosFem(EmpleadosDTO dato);

	Empleados getEmpleadosPorId(EmpleadosDTO dato);

	Empleados obtenerEmpleadosPorRfc(EmpleadosDTO dato);
	
	Empleados obtenerEmpleadosPorEstado(EmpleadosDTO dato);
	
	Empleados validarRfc(EmpleadosDTO dato);
	
	Empleados insertarEmpValidarRfc(EmpleadosDTO dato);
	
	Empleados validarCurp(EmpleadosDTO dato);
	
	Empleados validarNss(EmpleadosDTO dato);




}
