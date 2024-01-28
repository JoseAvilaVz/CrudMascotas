package mex.com.curso.ServicesImplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mex.com.curso.Dto.Mascotas;
import mex.com.curso.Dto.ResponseDto;
import mex.com.curso.Repository.IMascotasRepository;
import mex.com.curso.Services.IMascotas;

@Service // Capa de servicio con la anotacion @Service
public class MascotasServicesImpl implements IMascotas {

	@Autowired
	private IMascotasRepository iMascotasRepository;

	@Override
	public List<Mascotas> getMascotas() {
		return iMascotasRepository.getMascotas();
	}

	@Override
	public ResponseDto insertMascotas(Mascotas mascotas) {
		ResponseDto response = new ResponseDto();
		Integer respuesta = 0;
		respuesta = iMascotasRepository.insertMascotas(mascotas);
		if (respuesta == 1) {
			response.setCode(1);
			response.setMessage("Se inserto correctamente");
		} else {
			response.setCode(0);
			response.setMessage("No se inserto");
		}
		return response;
	}

	@Override
	public ResponseDto actualizarMascotas(Mascotas mascotas) {
		ResponseDto response = new ResponseDto();
		Integer respuesta = iMascotasRepository.actualizarMascotas(mascotas);
		if (respuesta == 1) {
			response.setCode(1);
			response.setMessage("Se Actualizo Correctamente la mascota: " + mascotas.getNombreMascota() + "Con Id: "
					+ mascotas.getIdMascota());
		} else {
			response.setCode(0);
			response.setMessage("No Se Actualizo Correctamente la mascota: " + mascotas.getNombreMascota() + "Con Id: "
					+ mascotas.getIdMascota());
		}
		return response;
	}

	@Override
	public ResponseDto eliminarMascotas(Mascotas mascotas) {
		ResponseDto response = new ResponseDto();
		Integer respuesta = iMascotasRepository.eliminarMascotas(mascotas);
		if (respuesta == 1) {
			response.setCode(1);
			response.setMessage("Se Elimino Correctamente la mascota Con Id: " + mascotas.getIdMascota());
		} else {
			response.setCode(0);
			response.setMessage("No Se Elimino Correctamente la mascota Con Id: " + mascotas.getIdMascota());
		}
		return response;
	}

}
