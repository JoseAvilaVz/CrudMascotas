package mex.com.curso.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import mex.com.curso.Dto.Mascotas;
import mex.com.curso.Dto.ResponseDto;
import mex.com.curso.Services.IMascotas;

@Controller // Anotacion para definir como controller
@RequestMapping("Masc") // Es buena practica poner nombre al controlador para diferenciar de los demas
						// usando @RequestMapping
public class ControllerMascotas {

	@Autowired
	private IMascotas iMascotas;

	@ResponseBody
	@RequestMapping(value = "/getMascotas", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Mascotas>> getMascotas() {
		final HttpHeaders httpHeaders = new HttpHeaders();
		List<Mascotas> mascotas = iMascotas.getMascotas();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON); // Tipo de contendio Json
		return new ResponseEntity<List<Mascotas>>(mascotas, httpHeaders, HttpStatus.OK);

	}

	@ResponseBody
	@RequestMapping(value = "/insertMascotas", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<ResponseDto> insertMascotas(@RequestBody Mascotas mascotas) {
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto response = new ResponseDto();
		response = iMascotas.insertMascotas(mascotas);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON); // Tipo de contendio Json
		return new ResponseEntity<ResponseDto>(response, httpHeaders, HttpStatus.OK);

	}

	@ResponseBody
	@RequestMapping(value = "/actualizarMascotas", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<ResponseDto> actualizarMascotas(@RequestBody Mascotas mascotas) {
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto response = new ResponseDto();
		System.out.println("Entrando al controlador Client, metodo actualizarClientes");
		response = iMascotas.actualizarMascotas(mascotas);
		System.out.println("Saliendo del metodo actualizarClientes de la implementacion del servicio");
		System.out.println("Regresando al controlador.");
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<ResponseDto>(response, httpHeaders, HttpStatus.OK);

	}

	@ResponseBody
	@RequestMapping(value = "/eliminarMascotas", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<ResponseDto> eliminarMascotas(@RequestBody Mascotas mascotas) {
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto response = new ResponseDto();
		System.out.println("Entrando al controlador Prov, metodo eliminarMascotas");
		response = iMascotas.eliminarMascotas(mascotas);
		System.out.println("Saliendo del metodo eliminarProveedores de la implementacion del servicio");
		System.out.println("Regresando al controlador.");
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<ResponseDto>(response, httpHeaders, HttpStatus.OK);
	}

}
