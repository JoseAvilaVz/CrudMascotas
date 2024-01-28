package mex.com.curso.Repository;

import java.util.List;


import mex.com.curso.Dto.UsuariosAdminDTO;
import mex.com.curso.Entidades.UsuariosAdmin;
  

//DAO - es un patron de diseño (Tiene una estructura que hay que cumplir) Data Acces Object
public interface UsuariosAdminDAO extends DAO<UsuariosAdmin, Long> {
	
	List<UsuariosAdmin> getUsuariosAdmin();

	List<UsuariosAdmin> getUsuariosAdminPorEstado(UsuariosAdminDTO datos);
}
