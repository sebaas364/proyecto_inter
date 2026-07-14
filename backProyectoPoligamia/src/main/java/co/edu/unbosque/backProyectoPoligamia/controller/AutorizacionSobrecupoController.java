package co.edu.unbosque.backProyectoPoligamia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.backProyectoPoligamia.dto.AutorizacionSobrecupoDTO;
import co.edu.unbosque.backProyectoPoligamia.service.AutorizacionSobrecupoService;

@RestController
@RequestMapping("/autorizacion")
@CrossOrigin("*")
public class AutorizacionSobrecupoController {

	@Autowired
	private AutorizacionSobrecupoService autorizacionServ;

	@PostMapping(path = "/createjson/{idSupervisor}/{idCompra}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createWithJSON(@PathVariable int idSupervisor, @PathVariable int idCompra,
			@RequestBody AutorizacionSobrecupoDTO nuevaAutorizacion) {
		int estado = autorizacionServ.create(idSupervisor, idCompra, nuevaAutorizacion);
		switch (estado) {
			case 0:
				return ResponseEntity.status(HttpStatus.CREATED).body("Autorización creada exitosamente");
			case 1:
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El supervisor no existe");
			case 2:
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La compra no existe");
			default:
				return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
						.body("Esa compra ya tiene una autorización registrada");
		}
	}

	@GetMapping("/getall")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(autorizacionServ.getAll());
	}

	@GetMapping("/get/{idAutorizacion}")
	public ResponseEntity<?> getById(@PathVariable int idAutorizacion) {

		AutorizacionSobrecupoDTO found = autorizacionServ.getById(idAutorizacion);
		if (found == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Autorización no encontrada");
		}
		return ResponseEntity.ok(found);
	}

	@PutMapping(path = "/update/{idAutorizacion}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> update(@PathVariable int idAutorizacion,
			@RequestBody AutorizacionSobrecupoDTO autorizacionDTO) {
		int estado = autorizacionServ.update(idAutorizacion, autorizacionDTO);
		return estado == 0
				? ResponseEntity.ok("Autorización actualizada exitosamente")
				: ResponseEntity.status(HttpStatus.NOT_FOUND).body("Autorización no encontrada");
	}

	@DeleteMapping("/delete/{idAutorizacion}")
	public ResponseEntity<String> delete(@PathVariable int idAutorizacion) {
		int estado = autorizacionServ.delete(idAutorizacion);
		return estado == 0
				? ResponseEntity.ok("Autorización eliminada exitosamente")
				: ResponseEntity.status(HttpStatus.NOT_FOUND).body("Autorización no encontrada");
	}

}