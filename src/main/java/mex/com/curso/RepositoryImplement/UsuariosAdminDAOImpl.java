package mex.com.curso.RepositoryImplement;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mex.com.curso.Dto.UsuariosAdminDTO;
import mex.com.curso.Entidades.UsuariosAdmin;
import mex.com.curso.Repository.UsuariosAdminDAO;

@Repository
public class UsuariosAdminDAOImpl extends GenericDAO<UsuariosAdmin, Long> implements UsuariosAdminDAO {

	@Override
	@SuppressWarnings("unchecked")// Quitar las advertencias (son las lineas amarillas)
	@Transactional() // Es lo equivalente a un commit en oracle (Confirmar los cambios)
	public List<UsuariosAdmin> getUsuariosAdmin() {
		
		final Session session = sessionFactory.getCurrentSession(); // 1 -> obt la session actual
		final Criteria criteria = session.createCriteria(UsuariosAdmin.class); 
//		criteria -> SELECT * FROM + ESQUEMA + USUARIOS_ADMIN --> select * from esquema.tabla;
		
		return (List<UsuariosAdmin>) criteria.list();
	}

	
	
	
	
	
	
	// Esta consultas es con Hibernate pero una condicion --->  select * from tabla where estado = ?
	@Override
	@SuppressWarnings("unchecked")
	@Transactional()
	public List<UsuariosAdmin> getUsuariosAdminPorEstado(UsuariosAdminDTO datos) {
		
		final Session session = sessionFactory.getCurrentSession(); // 1 -> obt la session actual
		final Criteria criteria = session.createCriteria(UsuariosAdmin.class);
//		criteria -> SELECT * FROM + ESQUEMA + USUARIOS_ADMIN --> select * from esquema.tabla;
		
		criteria.add(Restrictions.eq("estado", datos.getEstado())); // --> where estado = ?
//		criteria.add(Restrictions.eq("nombre", datos.nombre())); // --> where estado = ?
//		criteria.add(Restrictions.eq("otro campo", datos.otro campo)); // --> where estado = ?
		
		return (List<UsuariosAdmin>) criteria.list();
	}
		

}


	
