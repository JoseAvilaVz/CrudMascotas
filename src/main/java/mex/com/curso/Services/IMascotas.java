package mex.com.curso.Services;

import java.util.List;

import mex.com.curso.Dto.Mascotas;
import mex.com.curso.Dto.ResponseDto;

public interface IMascotas {

	public List<Mascotas> getMascotas();

	public ResponseDto insertMascotas(Mascotas mascotas);

	public ResponseDto actualizarMascotas(Mascotas mascotas);

	public ResponseDto eliminarMascotas(Mascotas mascotas);

}
