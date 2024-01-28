package mex.com.curso.Services;

import java.util.List;
import mex.com.curso.Dto.ResponseDto;
import mex.com.curso.Dto.UsuariosAdminDTO;
import mex.com.curso.Entidades.UsuariosAdmin;

public interface UsuariosAdminServices {
	
	List<UsuariosAdmin>obtenerUsuarios();
	
	List<UsuariosAdmin> obtenerUsuariosPorEstado(UsuariosAdminDTO datos);
	
	ResponseDto insertUsuariosAdmin(UsuariosAdminDTO nuevoUsuario);

	ResponseDto eliminarUsuario(UsuariosAdminDTO datos);

	ResponseDto actualizarUsuario(UsuariosAdminDTO datos);

	ResponseDto getUsuariosAdminPorId(UsuariosAdminDTO dato);

	

}


	
	


