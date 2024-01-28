package mex.com.curso.ServicesImplement;

// CAPA DE NEGOCIO
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mex.com.curso.Dto.EmpleadosDTO;
import mex.com.curso.Dto.ResponseDto;
import mex.com.curso.Dto.UsuariosAdminDTO;
import mex.com.curso.Entidades.Empleados;
import mex.com.curso.Entidades.UsuariosAdmin;
import mex.com.curso.Repository.UsuariosAdminDAO;
import mex.com.curso.Services.UsuariosAdminServices;

@Service
public class UsuariosAdminServicesImpl implements UsuariosAdminServices {

	@Autowired
	private UsuariosAdminDAO usuariosAdminDAO;
	

	
	
	public List<UsuariosAdmin> obtenerUsuarios() {
		List<UsuariosAdmin> listaUsuarios = usuariosAdminDAO.getUsuariosAdmin();
		return listaUsuarios;
	}
	


	@Override
	public List<UsuariosAdmin> obtenerUsuariosPorEstado (UsuariosAdminDTO datos) {
		List<UsuariosAdmin> listaUsuariosPorEstado = usuariosAdminDAO.getUsuariosAdminPorEstado(datos);
		return listaUsuariosPorEstado;
	}


	/*
	 * ESTE METODO ES PARA INSERTAR CON HIBERNATE 
	 */
	@Override
	public ResponseDto insertUsuariosAdmin(UsuariosAdminDTO nuevoUsuario) {
		ResponseDto response = new ResponseDto(); // inicializar en obj en vacio
		
		/*Los datos que se mandan desde Postman vienen en el objt -----> nuevoUsuario
		  
nuevoUsuario =	{
					"idUser" : "1",
					"nombreCompleto" : "x",
					"edad" : "18",
					"direccion" : "calle x"
				}
		 */
		
		
// REGLA #1 -> Para trabajar con hibernate se usa un objeto de la clase entidad para traspasar la informacion 
// JDBC ---> INSERT INTO (CAMPO1, CAMPO2, ...) VALUES (valor1, valor,2,..... las incognitas)
// HIBERNATE --> la inf que trae el DTO hay que trasladar esa info a un obj de la entidad -> create
		 
		
		UsuariosAdmin objtEntidad = new UsuariosAdmin(); // creando un obj con nombre->(objtEntidad) de la clase entiudad
		objtEntidad.setIdUser(nuevoUsuario.getIdUser());
		objtEntidad.setNombreCompleto(nuevoUsuario.getNombreCompleto());
		objtEntidad.setEdad(nuevoUsuario.getEdad());
		objtEntidad.setDireccion(nuevoUsuario.getDireccion());
		objtEntidad.setEstado(nuevoUsuario.getEstado());
		objtEntidad.setRol(nuevoUsuario.getRol());
		
/*		objtEntidad =	{
					"idUser" : "1",
					"nombreCompleto" : "x",
					"edad" : "18",
					"direccion" : "calle x",
				}
  */
 
		usuariosAdminDAO.create(objtEntidad); // create --> insert con hibernate
		response.setCode(200);
		response.setMessage("Los datos se insertaron correctamente..!");
		
		return response;
	}



	@Override
	public ResponseDto eliminarUsuario(UsuariosAdminDTO datos) {
		
		ResponseDto response = new ResponseDto();
		
		
		usuariosAdminDAO.delete(datos.getIdUser());
		response.setCode(200);
		response.setMessage("El registro se elimno correctamente");
		
		
		return response;
	}



	/*@Override
	public ResponseDto actualizarUsuario(UsuariosAdminDTO dato) {
		ResponseDto response = new ResponseDto();
		
		Empleados objeto = new Empleados(); // creando un obj con nombre->(objtEntidad) de la clase entiudad
		objeto.setIdEmpleado(dato.getIdUser());
		objeto.setNombreCompleto(dato.getNombreCompleto());
		objeto.setRfc(dato.getRfc());
		objeto.setCurp(dato.getCurp());
		objeto.setEdad(dato.getEdad());
		objeto.setSexo(dato.getSexo());
		objeto.setDireccion(dato.getDireccion());
		objeto.setNss(dato.getNss());
		objeto.setActivo(dato.getActivo());

		usuariosAdminDAO.update(dato.getIdUser());
		response.setCode(200);
		response.setMessage("El Empleado se actualizo correctamente");
		
		return response;
	}*/



	@Override
	public ResponseDto getUsuariosAdminPorId(UsuariosAdminDTO dato) {
		ResponseDto response = new ResponseDto();
		/*LOS DATOS QUE SE MANDAN DESDE POSTMAN VIENEN EN EL OBJT...nuevoUsuario
		
		 * 		"idUser" : "1",
				"nombreCompleto" : "",
				"edad" : "",
				"direccion" : "calle "",
		 */
		
		usuariosAdminDAO.read(dato.getIdUser()); // consulta--> SELECT * FROM WHERE ID =?
		response.setCode(200);
		response.setMessage("Uusuario Localizado");
		
		return response;
	}



	@Override
	public ResponseDto actualizarUsuario(UsuariosAdminDTO datos) {
		// TODO Auto-generated method stub
		return null;
	}







	

		
	
		
	}




