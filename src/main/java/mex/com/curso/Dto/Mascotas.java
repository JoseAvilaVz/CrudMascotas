package mex.com.curso.Dto;

public class Mascotas {
	
	private Integer idMascota;
	private String nombreMascota;
	private String raza;
	private String alergias;
	private Integer edad;
	private String dieta;
	
	
	
	public Integer getIdMascota() {
		return idMascota;
	}
	public void setIdMascota(Integer idMascota) {
		this.idMascota = idMascota;
	}
	public String getNombreMascota() {
		return nombreMascota;
	}
	public void setNombreMascota(String nombreMascota) {
		this.nombreMascota = nombreMascota;
	}
	public String getRaza() {
		return raza;
	}
	public void setRaza(String raza) {
		this.raza = raza;
	}
	public String getAlergias() {
		return alergias;
	}
	public void setAlergias(String alergias) {
		this.alergias = alergias;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public String getDieta() {
		return dieta;
	}
	public void setDieta(String dieta) {
		this.dieta = dieta;
	}
	@Override
	public String toString() {
		return "Mascotas [idMascota=" + idMascota + ", nombreMascota=" + nombreMascota + ", raza=" + raza
				+ ", alergias=" + alergias + ", edad=" + edad + ", dieta=" + dieta + "]";
	}
	
	
	

}
