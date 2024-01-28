package mex.com.curso.Repository;

import java.util.List;

import mex.com.curso.Dto.Mascotas;

public interface IMascotasRepository {

	public List<Mascotas> getMascotas();

	public Integer insertMascotas(Mascotas mascotas);

	public Integer actualizarMascotas(Mascotas mascotas);

	public Integer eliminarMascotas(Mascotas mascotas);

}
