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

import co.edu.unbosque.backProyectoPoligamia.dto.AlmacenDTO;
import co.edu.unbosque.backProyectoPoligamia.service.AlmacenService;

@RestController
@RequestMapping("/almacen")
@CrossOrigin("*")
public class AlmacenController {

	@Autowired
	private AlmacenService almacenServ;

	@PostMapping(path = "/createjson", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createWithJSON(@RequestBody AlmacenDTO nuevoAlmacen) {
		int estado = almacenServ.create(nuevoAlmacen);
		return estado == 0
				? ResponseEntity.status(HttpStatus.CREATED).body("Almacén creado exitosamente")
				: ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Error al crear el almacén");
	}

	@GetMapping("/getall")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(almacenServ.getAll());
	}

	@GetMapping("/get/{idAlmacen}")
	public ResponseEntity<?> getById(@PathVariable int idAlmacen) {

		AlmacenDTO found = almacenServ.getById(idAlmacen);
		if (found == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Almacén no encontrado");
		}
		return ResponseEntity.ok(found);
	}

	@PutMapping(path = "/update/{idAlmacen}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> update(@PathVariable int idAlmacen, @RequestBody AlmacenDTO almacenDTO) {
		int estado = almacenServ.update(idAlmacen, almacenDTO);
		return estado == 0
				? ResponseEntity.ok("Almacén actualizado exitosamente")
				: ResponseEntity.status(HttpStatus.NOT_FOUND).body("Almacén no encontrado");
	}

	@DeleteMapping("/delete/{idAlmacen}")
	public ResponseEntity<String> delete(@PathVariable int idAlmacen) {
		int estado = almacenServ.delete(idAlmacen);
		return estado == 0
				? ResponseEntity.ok("Almacén eliminado exitosamente")
				: ResponseEntity.status(HttpStatus.NOT_FOUND).body("Almacén no encontrado");
	}

}