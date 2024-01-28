package mex.com.curso.Repository;

import java.util.List;
import mex.com.curso.Dto.Proveedores;

public interface IProveedoresRepository {
	public List<Proveedores> getProveedores(); // es el mismo metodo de la interfaceDeServicio metodo get de tipo lista
	public Integer insertProveedores(Proveedores proveedores);
	public Integer actualizarProveedores (Proveedores proveedores);
	public Integer eliminarProveedores (Proveedores proveedores);

}
