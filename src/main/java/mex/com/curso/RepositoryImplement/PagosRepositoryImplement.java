package mex.com.curso.RepositoryImplement;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import mex.com.curso.Dto.Pagos;
import mex.com.curso.Mapper.PagosMapper;
import mex.com.curso.Repository.IPagosRepository;

@Repository
public class PagosRepositoryImplement implements IPagosRepository{

	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate = new JdbcTemplate();
	
	@Override
	public List<Pagos> getPagos() {
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.query("SELECT * FROM PAGOS", new PagosMapper<Pagos>());
		
	}
	
	@Override
	public Integer insertPagos(Pagos pago) {
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.update("INSERT INTO PAGOS" +
		"(NOMBRE_CLIENTE, PRODUCTO,CANTIDAD, TOTAL_COMPRA, FACTURA)"+
			"VALUES(?,?,?,?,?)", new Object[]{pago.getNombreCliente(), pago.getProducto(),
				pago.getCantidad(), pago.getTotalCompra(), pago.getFactura()});
	}
	
	@Override
	public Integer actualizarPagos(Pagos pago) {
		System.out.println("LLegando a la implementacion del repositorio del metodo actualizarPagos");
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.update("UPDATE PAGOS SET NOMBRE_CLIENTE =?, PRODUCTO= ?, CANTIDAD = ?, "
				+"TOTAL_COMPRA = ?, FACTURA = ? WHERE ID_PAGO = ?", new Object [] {pago.getNombreCliente(), pago.getProducto(),
						pago.getCantidad(), pago.getTotalCompra(), pago.getFactura(), pago.getIdPago()});
	}
	
	@Override
	public Integer eliminarPagos(Pagos pago) {
		jdbcTemplate.setDataSource(getDataSource()); 
		return jdbcTemplate.update("DELETE FROM PAGOS WHERE ID_PAGO = ?", pago.getIdPago());
		}

	 
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public JdbcTemplate getJbdcTemplete() {
		return jdbcTemplate;
	}

	public void setJbdcTemplete(JdbcTemplate jbdcTemplete) {
		this.jdbcTemplate = jbdcTemplete;
	}

	

	


	

	
	

	

}
