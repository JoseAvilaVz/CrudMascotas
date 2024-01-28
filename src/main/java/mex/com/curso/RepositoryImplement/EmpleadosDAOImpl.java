package mex.com.curso.RepositoryImplement;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mex.com.curso.Dto.EmpleadosDTO;
import mex.com.curso.Dto.ResponseDto;
import mex.com.curso.Entidades.Empleados;
import mex.com.curso.Repository.EmpleadosDAO;

@Repository
public class EmpleadosDAOImpl extends GenericDAO<Empleados, Long> implements EmpleadosDAO {

	// POR ESTADO

	// Esta consulta es con Hibernate trae la lista de empleados existente

	@Override
	@SuppressWarnings("unchecked") // Quitar las advertencias (son las lineas amarillas)
	@Transactional() // Es lo equivalente a un commit en oracle (Confirmar los cambios)
	public List<Empleados> getEmpleados() {
		final Session session = sessionFactory.getCurrentSession(); // 1 -> obt la session actual
		final Criteria criteria = session.createCriteria(Empleados.class);
		// criteria -> SELECT * FROM + ESQUEMA + USUARIOS_ADMIN --> select * from
		// esquema.tabla;

		return (List<Empleados>) criteria.list();
	}

//Esta consulta es con Hibernate pero con una condicion --> select * from tabla where activo = ?

	@Override
	@SuppressWarnings("unchecked") // Quitar las advertencias (son las lineas amarillas)
	@Transactional() // Es lo equivalente a un commit en oracle (Confirmar los cambios)
	public List<Empleados> getEmpleadosPorEstado(EmpleadosDTO dato) {

		final Session session = sessionFactory.getCurrentSession(); // 1 -> obt la session actual
		final Criteria criteria = session.createCriteria(Empleados.class);
//		criteria -> SELECT * FROM + ESQUEMA + USUARIOS_ADMIN --> select * from esquema.tabla;

		criteria.add(Restrictions.eq("activo", dato.getActivo())); // --> where estado = ?
//		criteria.add(Restrictions.eq("nombre", datos.nombre())); // --> where estado = ?
//		criteria.add(Restrictions.eq("otro campo", datos.otro campo)); // --> where estado = ?

		return (List<Empleados>) criteria.list();
	}

	// Esta consulta es con Hibernate pero con una condicion --> select * from tabla
	// where IdEmpleado = ?

	@Override
	@SuppressWarnings("unchecked") // Quitar las advertencias (son las lineas amarillas)
	@Transactional() // Es lo equivalente a un commit en oracle (Confirmar los cambios)
	public Empleados getEmpleadosPorId(EmpleadosDTO dato) {
		final Session session = sessionFactory.getCurrentSession(); // 1 -> obt la session actual
		final Criteria criteria = session.createCriteria(Empleados.class);

		criteria.add(Restrictions.eq("idEmpleado", dato.getIdEmpleado())); // --> where estado = ?
		criteria.add(Restrictions.eq("activo",dato.getActivo())); // --> where estado = ?

		return (Empleados) criteria.list();
	}

	// Esta consulta es con Hibernate pero con una condicion --> select * from
	// EMPLEADOS where SEXO = ?
	// Consultar todos los usuarios de sexo Masculino
	@Override
	@SuppressWarnings("unchecked") // Quitar las advertencias (son las lineas amarillas)
	@Transactional() // Es lo equivalente a un commit en oracle (Confirmar los cambios)
	public List<Empleados> getEmpleadosMasc(EmpleadosDTO dato) {
		final Session session = sessionFactory.getCurrentSession(); // 1 -> obt la session actual
		final Criteria criteria = session.createCriteria(Empleados.class);

		criteria.add(Restrictions.eq("sexo", "M")); // --> where estado = ?
//			criteria.add(Restrictions.eq("nombre", datos.nombre())); // --> where estado = ?
//			criteria.add(Restrictions.eq("otro campo", datos.otro campo)); // --> where estado = ?
		return (List<Empleados>) criteria.list();
	}

	// Esta consulta es con Hibernate pero con una condicion --> select * from
	// EMPLEADOS where SEXO = ?
	// Consultar todos los usuarios de sexo Femenino
	@Override
	@SuppressWarnings("unchecked") // Quitar las advertencias (son las lineas amarillas)
	@Transactional() // Es lo equivalente a un commit en oracle (Confirmar los cambios)
	public List<Empleados> getEmpleadosFem(EmpleadosDTO dato) {
		final Session session = sessionFactory.getCurrentSession(); // 1 -> obt la session actual
		final Criteria criteria = session.createCriteria(Empleados.class);

		criteria.add(Restrictions.eq("sexo", "F")); // --> where estado = ?
		criteria.add(Restrictions.eq("edad", dato.getEdad())); // --> where estado = ?
//			criteria.add(Restrictions.eq("otro campo", datos.otro campo)); // --> where estado = ?

		return (List<Empleados>) criteria.list();
	}

	@Override
	@SuppressWarnings("unchecked") // Quitar las advertencias (son las lineas amarillas)
	@Transactional() // Es lo equivalente a un commit en oracle (Confirmar los cambios)
	public Empleados obtenerEmpleadosPorRfc(EmpleadosDTO dato) {
		final Session session = sessionFactory.getCurrentSession(); // 1 -> obt la session actual
		final Criteria criteria = session.createCriteria(Empleados.class);

		criteria.add(Restrictions.eq("rfc", dato.getRfc())); // --> where estado = ?

		return (Empleados) criteria.uniqueResult();
	}

	@Override
	@SuppressWarnings("unchecked") // Quitar las advertencias (son las lineas amarillas)
	@Transactional() // Es lo equivalente a un commit en oracle (Confirmar los cambios)
	public Empleados obtenerEmpleadosPorEstado(EmpleadosDTO dato) {
		
		final Session session = sessionFactory.getCurrentSession(); // 1 -> obt la session actual
		final Criteria criteria = session.createCriteria(Empleados.class);
		
		criteria.add(Restrictions.eq("activo", 1)); // --> where estado = ?
		

		return 	(Empleados) criteria.uniqueResult(); // --> where estado = ?

	}

	@Override
	@SuppressWarnings("unchecked") // Quitar las advertencias (son las lineas amarillas)
	@Transactional() // Es lo equivalente a un commit en oracle (Confirmar los cambios)
	public Empleados validarRfc(EmpleadosDTO dato) {
		final Session session = sessionFactory.getCurrentSession(); // 1 -> obt la session actual
		final Criteria criteria = session.createCriteria(Empleados.class);

		criteria.add(Restrictions.eq("rfc", dato.getRfc())); // --> where estado = ?

		return (Empleados) criteria.uniqueResult();
	}

	//Esta consulta es con Hibernate pero con una condicion --> select * from tabla where activo = ?
	//SE OCUPO PARA INSERTAR UN NUEVO EMPLEADO MEDIANTE LA VALIDACION DEL RFC
	@Override
	@SuppressWarnings("unchecked") // Quitar las advertencias (son las lineas amarillas)
	@Transactional() // Es lo equivalente a un commit en oracle (Confirmar los cambios)
	public Empleados insertarEmpValidarRfc(EmpleadosDTO dato) {
		
		final Session session = sessionFactory.getCurrentSession(); // 1 -> obt la session actual
		final Criteria criteria = session.createCriteria(Empleados.class);
			
		criteria.add(Restrictions.eq("rfc", dato.getRfc())); // --> where estado = ?
		return (Empleados) criteria.uniqueResult();
	}

	@Override
	@SuppressWarnings("unchecked") // Quitar las advertencias (son las lineas amarillas)
	@Transactional() // Es lo equivalente a un commit en oracle (Confirmar los cambios)
	public Empleados validarCurp(EmpleadosDTO dato) {
		final Session session = sessionFactory.getCurrentSession(); // 1 -> obt la session actual
		final Criteria criteria = session.createCriteria(Empleados.class);
			
		criteria.add(Restrictions.eq("curp", dato.getCurp())); // --> where estado = ?
		
		return (Empleados) criteria.uniqueResult();
	}

	@Override
	@SuppressWarnings("unchecked") // Quitar las advertencias (son las lineas amarillas)
	@Transactional() // Es lo equivalente a un commit en oracle (Confirmar los cambios)
	public Empleados validarNss(EmpleadosDTO dato) {
		
		final Session session = sessionFactory.getCurrentSession(); // 1 -> obt la session actual
		final Criteria criteria = session.createCriteria(Empleados.class);
			
		criteria.add(Restrictions.eq("nss", dato.getNss())); // --> where estado = ?
		
		return (Empleados) criteria.uniqueResult();
	}

	



}
