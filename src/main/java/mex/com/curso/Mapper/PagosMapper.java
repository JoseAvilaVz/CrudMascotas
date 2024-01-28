package mex.com.curso.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import mex.com.curso.Dto.Pagos;

public class PagosMapper<T> implements RowMapper<Pagos>  {

	@Override
	public Pagos mapRow(ResultSet rs, int rowNum) throws SQLException {
		Pagos pagos  = new Pagos ();
		pagos.setIdPago(rs.getLong("ID_PAGO"));
		pagos.setNombreCliente(rs.getString("NOMBRE_CLIENTE"));
		pagos.setProducto(rs.getString("PRODUCTO"));
		pagos.setCantidad(rs.getLong("CANTIDAD"));
		pagos.setTotalCompra(rs.getLong("TOTAL_COMPRA"));
		pagos.setFactura(rs.getString("FACTURA"));
		
		return pagos;
	}

}
