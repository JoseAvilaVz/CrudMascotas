package mex.com.curso.Services;

import java.util.List;
import mex.com.curso.Dto.Pagos;
import mex.com.curso.Dto.ResponseDto;

public interface IPagos {

	public List<Pagos> getPagos();
	public ResponseDto insertPagos(Pagos pago);
	public ResponseDto actualizarPagos(Pagos pago);
	public ResponseDto eliminarPagos(Pagos pago);

	
}
