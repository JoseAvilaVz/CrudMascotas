package mex.com.curso.Entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // Anotacion para indicarle que esta clase va a ser una entity/entidad
@Table(name = "EMPLEADOS", schema = "CURSOCTUBRE") // Anotacion table donde indicamos el nombre de la tabla y el esquema
public class Empleados {

	@Id // Es para indicarle que el campo/atributo va ser un id
	@Column(name = "ID_EMPLEADO", unique = true, nullable = false, precision = 11) // Es para indicar que es una columna
																					// de la tabla y se pueden agregar
																					// propiedades
	private Long idEmpleado; // Atributo es la que se usa aqui en codigo

	@Column(name = "NOMBRE_COMPLETO", length = 100)
	private String nombreCompleto;

	@Column(name = "RFC")
	private String rfc;

	@Column(name = "CURP")
	private String curp; 

	@Column(name = "EDAD")
	private int edad;

	@Column(name = "SEXO")
	private String sexo;

	@Column(name = "DIRECCION")
	private String direccion;

	@Column(name = "NSS")
	private int nss;

	@Column(name = "TELEFONO")
	private Long telefono;

	@Column(name = "ACTIVO")
	private int activo;

	public Long getIdEmpleado() {
		return idEmpleado;
	}

	// Setter & Getters

	public void setIdEmpleado(Long idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getCurp() {
		return curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getNss() {
		return nss;
	}

	public void setNss(int nss) {
		this.nss = nss;
	}

	public Long getTelefono() {
		return telefono;
	}

	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}


}
