package mex.com.curso.Repository;

import java.util.List;


import mex.com.curso.Dto.Pagos;


public interface IPagosRepository {
	public List<Pagos> getPagos();
	public Integer insertPagos(Pagos pago);
	public Integer actualizarPagos(Pagos pago);
	public Integer eliminarPagos(Pagos pago);

}
