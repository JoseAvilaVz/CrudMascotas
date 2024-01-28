package mex.com.curso.Dto;
									//Se Realizo Primero 
public class Pagos {
	
	private Long idPago;
	private String nombreCliente;
	private String producto;
	private Long cantidad;    		//Variables a corde a la tabla de la Base de Datos.
	private Long totalCompra;
	private String factura;
	
	
	public Long getIdPago() {       // Generamos Getter & Setters
		return idPago;
	}									
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public Long getCantidad() {
		return cantidad;
	}
	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}
	public Long getTotalCompra() {
		return totalCompra;
	}
	public void setTotalCompra(Long totalCompra) {
		this.totalCompra = totalCompra;
	}
	public String getFactura() {
		return factura;
	}
	public void setFactura(String factura) {
		this.factura = factura;
	}
	public void setIdPago(Long idPago) {
		this.idPago = idPago;
	}
	
	@Override     // Generamos metodo toString							
	public String toString() {
		return "Pagos [idPago=" + idPago + ", nombreCliente=" + nombreCliente + ", producto=" + producto + ", cantidad="
				+ cantidad + ", totalCompra=" + totalCompra + ", factura=" + factura + "]";
	}
	
	
	
}
