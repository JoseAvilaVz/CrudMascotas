package mex.com.curso.Services;

import java.util.List;

import mex.com.curso.Dto.Proveedores;
import mex.com.curso.Dto.ResponseDto;

public interface IProveedores {
	 public List<Proveedores> getProveedores(); //Metodo de tipo lista
	 public ResponseDto insertProveedores (Proveedores proveedor);
	 public ResponseDto actualizarProveedores (Proveedores proveedores);
	 public ResponseDto eliminarProveedores (Proveedores proveedores);
	  

}
